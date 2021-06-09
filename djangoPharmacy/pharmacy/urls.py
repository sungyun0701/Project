from django.urls import path

from pharmacy import views

app_name = 'pharmacy'

urlpatterns = [
    # path('test', views.json_test, name='test'),
    path('query', views.query, name='query'),
    path('geo', views.geocode_find, name='geo'),
]