from django.http import HttpResponse
from django.shortcuts import render


from MyMongoClient import MyMongoClient


class Pharmacy(object):
    def __init__(self):
        self.name = ''
        self.address = ''
        self.latitude: 0.0
        self.longitude: 0.0

# import requests
# def json_test(request):
#     if request.method == 'GET':
#         return render(request, 'pharmacy/test.html')
#
#     if request.method == 'POST':
#
#         address=request.POST['address']
#         print(address)
#         print(type(address))
#         radius=int(request.POST['radius'])
#         url = f'https://maps.googleapis.com/maps/api/geocode/json?address={address}&key=AIzaSyDAQCdTZ49zdFnOVyByYUz_eojJT1YDfEc'
#         res = requests.get(url)
#         data = res.json()
#         lat = data['results'][0]['geometry']['location']['lat']
#         lng = data['results'][0]['geometry']['location']['lng']
#         print(data['results'][0]['geometry']['location']['lng'])
#         myMongoClient = MyMongoClient()
#         myCollection = myMongoClient.collection
#         myCollection.create_index([('location', '2dsphere')])
#         maxDistance = radius
#         pharmacy = myCollection.find(
#             {
#                 'location':
#                     {'$near':
#                         {
#                             '$geometry': {'type': 'Point',
#                                           # 'coordinates': [128.62705, 35.88102]},
#                                           'coordinates': [lng, lat]},
#                             '$minDistance': 0,
#                             '$maxDistance': maxDistance
#                         }
#                     }
#             }
#         )
#
#         # for item in pharmacy:
#         #     print(item)
#
#         pharmacy_list = []
#         cnt = 0
#         for item in pharmacy:
#             phar = Pharmacy()
#             phar.name = item['pharmacy_name']
#             phar.address = item['address']
#             phar.latitude = item['location']['coordinates'][1]
#             phar.longitude = item['location']['coordinates'][0]
#             pharmacy_list.append(phar)
#             cnt += 1
#         # pharmacy = json.dumps(pharmacy)
#
#         # locations = [
#         #     item
#         #     for item in pharmacy
#         # ]
#         #
#         # for item in locations:
#         #     json_str = json.dumps(item)
#         #     print(json_str)
#
#         # for item in pharmacy:
#         #
#         #     print(item['location']['coordinates'][1])
#
#         contex = {
#             'pharmacy_list': pharmacy_list, 'cnt': cnt, 'lat': lat, 'lng': lng, 'address': address,'radius':radius,
#         }
#
#         return render(request, 'pharmacy/googlemap.html', contex)


import googlemaps
def geocode_find(request):
    # 2번째 방법(import googlemaps)
    gmaps = googlemaps.Client(key='AIzaSyDAQCdTZ49zdFnOVyByYUz_eojJT1YDfEc')
    result = gmaps.geocode('서울시청')
    print(result[0]['geometry']['location']['lat'])
    print(result[0]['geometry']['location']['lng'])
    # title = request.POST['address']
    # print(title)
    # print(type(title))
    return render(request, 'pharmacy/geocode_find.html')


import re
def query(request):
    myMongoClient = MyMongoClient()
    myCollection = myMongoClient.collection
    myCollection.create_index([('location', '2dsphere')])
    # 1번째방법
    locate = request.GET['latlng']
    address = request.GET['site']
    radius = int(request.GET.get('radius'))
    print('locate='+locate)
    print(address)
    print(type(address))
    locate = re.findall("\d+",locate)
    print(locate)
    # we = locate[1:9]
    # gu = locate[12:20]
    # print(we)
    # print(gu)
    lat = float(locate[0]+'.'+locate[1])
    # print(lat)
    # print(type(lat))
    lng = float(locate[2]+'.'+locate[3])

    print(lat)
    print(lng)




    maxDistance = radius
    pharmacy = myCollection.find(
        {
            'location':
                {'$near':
                    {
                        '$geometry': {'type': 'Point',
                                      # 'coordinates': [128.62705, 35.88102]},
                                        'coordinates': [lng, lat]},
                        '$minDistance': 0,
                        '$maxDistance': maxDistance
                    }
                }
        }
    )

    # for item in pharmacy:
    #     print(item)

    pharmacy_list = []
    cnt = 0
    for item in pharmacy:
        phar = Pharmacy()
        phar.name = item['pharmacy_name']
        phar.address = item['address']
        phar.latitude = item['location']['coordinates'][1]
        phar.longitude = item['location']['coordinates'][0]
        cnt += 1
        phar.cnt=cnt
        pharmacy_list.append(phar)

    # pharmacy = json.dumps(pharmacy)

    # locations = [
    #     item
    #     for item in pharmacy
    # ]
    #
    # for item in locations:
    #     json_str = json.dumps(item)
    #     print(json_str)

    # for item in pharmacy:
    #
    #     print(item['location']['coordinates'][1])

    contex = {
        'pharmacy_list': pharmacy_list,'cnt':cnt,'lat':lat, 'lng':lng, 'address':address, 'radius':radius,
    }

    return render(request, 'pharmacy/googlemap.html', contex)
