from pymongo import MongoClient


class MyMongoClient:
    def __init__(self):
        self.connect_string = 'mongodb+srv://sungyun:qwer123@cluster0.hyk9r.mongodb.net/naver_movie?retryWrites=true&w=majority'
        self.client = MongoClient(self.connect_string)
        self.db = self.client['naver_movie']
        self.collection = self.db['bigdata']
