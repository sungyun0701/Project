import base64
import traceback
from io import BytesIO
from time import sleep

from PIL import Image

from flask import Flask, render_template
import requests
from bs4 import BeautifulSoup

from Movie import Movie
from MyMongoClient import MyMongoClient

app = Flask(__name__)


@app.route('/show')
def show():
    myMongoClient = MyMongoClient()
    myCollection = myMongoClient.collection
    naver_movie = myCollection.find()
    movie_list = []

    for movies in naver_movie:
        movie_list.append(movies)

    # ========풀어쓴것 여기서 클래스를 만들어서 쓴것==============
    # for movie_item in naver_movie:
    #     movie = Movie()
    #
    #     movie.seq = movie_item['seq']
    #     movie._id = movie_item['_id']
    #     movie.im_b64_docode = movie_item['im_b64_docode']
    #     movie.view_rate = movie_item['view_rate']
    #     movie.movie_title = movie_item['movie_title']
    #     movie.estimated_target = movie_item['estimated_target']
    #     movie.estimated_score = movie_item['estimated_score']
    #     movie.estimated_people = movie_item['estimated_people']
    #
    #     movie.movie_type_caption = movie_item['movie_type_caption']
    #     movie.movie_type = movie_item['movie_type']
    #     movie.movie_director_caption = movie_item['movie_director_caption']
    #     movie.movie_director = movie_item['movie_director']
    #     movie.actor_list = movie_item['actor_list']
    #
    #     movie_list.append(movie)
    # =========================================================

    return render_template('show_movie.html', movies=movie_list)


@app.route('/')
def get_naver_movie():
    myMongoClient = MyMongoClient()
    myCollection = myMongoClient.collection
    total_count = myCollection.count()
    if total_count > 0:
        myCollection.drop()

    uri = 'https://movie.naver.com/movie/running/current.nhn'
    response = requests.get(uri)
    soup = BeautifulSoup(response.content, 'html.parser')

    ul = soup.find('ul', class_='lst_detail_t1')
    li = ul.find_all('li')

    seq = 0
    error = 0
    size = (450, 450)
    for item in li:
        seq += 1
        try:

            img = item.find('img')
            img_src = img.get('src')
            img_data = requests.get(img_src)
            b = BytesIO(img_data.content)

            img = Image.open(b)
            img.thumbnail(size)  # 작은 그림

            im_file = BytesIO()
            # img.save(im_file, format='JPEG')
            img.save(im_file, format='png')
            im_bytes = im_file.getvalue()  # im_bytes: image in binary format.
            im_b64 = base64.b64encode(im_bytes)
            im_b64_docode = im_b64.decode()

            view_rate = [view_rate.text for view_rate in item.select('dl > dt > span')]
            movie_title = item.select('dl > dt > a')[0].text
            estimated_target = item.select('dl > dd.star > dl.info_star > dt')[0].text
            estimated_score = item.select('dl > dd.star > dl.info_star > dd > div > a > span.num')[0].text
            estimated_people = item.select('dl > dd.star > dl.info_star > dd > div > a > span.num2 > em')[0].text
            #reservation_rate = age = [ag.text for ag in item.select('dl > dt > span')]
            movie_type_caption = item.select('dd > dl.info_txt1 > dt.tit_t1')[0].text
            movie_type = item.select('dd > dl.info_txt1 > dd> span.link_txt > a')[0].text
            movie_director_caption = item.select('dl > dd > dl > dt.tit_t2')[0].text
            movie_director = item.select('dl > dd:nth-child(3) > dl > dd:nth-child(4) > span > a')[0].text
            #movie_actor_caption = item.select('dl > dd:nth-child(3) > dl > dt.tit_t3')[0]
            #print(movie_actor_caption.text)

            #actor_list = [actor.text for actor in item.select('dl > dd:nth-child(3) > dl > dd:nth-child(6) > span > a')]
            #print(actor_list)
            actor_list = [actor.text for actor in item.select('dl > dd:nth-child(3) > dl > dd:nth-child(6) > span > a')]

            myDocument = {'seq': seq, 'im_b64_docode': im_b64_docode, 'view_rate': view_rate,
             'movie_title': movie_title, 'estimated_target': estimated_target,
             'estimated_score': estimated_score, 'estimated_people': estimated_people,
             'movie_type_caption': movie_type_caption, 'movie_type': movie_type,
             'movie_director_caption': movie_director_caption,
             'movie_director': movie_director, 'actor_list': actor_list
            }
            print(myDocument)
            myCollection.insert_one(myDocument)

        except Exception as e:
            error += 1
            print(traceback.format_exc())
        # w, h = im.size
    print(seq)
    print(error)
#



        # print(w, h)

        # with open(img_src, 'rb') as image_file:
        #
        #     encoded_data = base64.b64encode(image_file.read())
        #     print(encoded_data)
        # view_rate = item.select('dl > dt > span')[0]
        # movie_title = item.select('dl > dt > a')[0]
        # estimated_target = item.select('dl > dd.star > dl.info_star > dt')[0]
        # print(estimated_target.text)


    return '네이버 영화 빅데이터 수집'


if __name__ == '__main__':
    app.run()
