from pymongo import MongoClient


class MyMongoClient:
    def __init__(self):
        self.client = MongoClient('mongodb+srv://sungyun:qwer123@cluster0.hyk9r.mongodb.net/pharmacy2019_db?retryWrites=true&w=majority')
        self.db = self.client['pharmacy2019_db']
        #self.db = self.client.pharm2019_db
        self.collection = self.db['pharm2019_collection']
