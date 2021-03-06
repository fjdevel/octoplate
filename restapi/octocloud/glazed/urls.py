"""octocloud URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from .views import ProcesarPlaca,ViewSetPlacas
from rest_framework import renderers

from django.urls import path


placalist = ProcesarPlaca.as_view({
	'get':'list',
	'post':'create'
	})
placaprocesamiento = ProcesarPlaca.as_view({
	'get':'obtenerPlaca'
	})

placacrud = ViewSetPlacas.as_view({
	'get':'list',
	'post':'create'
	})
urlpatterns = [
	path('subirimagen',placalist,name='subida'),
	path('obtenerplaca/<identificador>/',placaprocesamiento,name='procesamiento'),
	path('placa/',placacrud,name='placacrud'),
]
