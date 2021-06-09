from bson import ObjectId


class Movie:
    def __init__(self):
        self._id: ObjectId()
        self.seq: 0
        self.im_b64_docode: ''
        self.view_rate: ''
        self.movie_title: ''
        self.estimated_target: ''
        self.estimated_score: 0.0
        self.estimated_people: ''
        self.movie_type_caption: ''
        self.movie_type: ''
        self.movie_director_caption: ''
        self.movie_director: ''
        self.actor_list: ''
