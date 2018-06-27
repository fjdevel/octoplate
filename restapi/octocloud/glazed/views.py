from django.shortcuts import render
from django.http import HttpResponse
import base64
import json
import requests
from rest_framework.views import APIView
from rest_framework.response import Response
from .serializers import ImageUploadSerializer,PlacaSerializer
from .models import ImageUpload,Placa
from rest_framework import viewsets
from rest_framework.decorators import action


# Create your views here.

class ProcesarPlaca(viewsets.ModelViewSet):
	queryset = ImageUpload.objects.all()
	serializer_class = ImageUploadSerializer

	@action(detail=True)
	def obtenerPlaca(request, *args, **kwargs):
		imagen = ImageUpload.objects.get() 
		with open(imagen.datafile.url, 'rb') as image_file:
			img_base64 = base64.b64encode(image_file.read())

		url = 'https://api.openalpr.com/v2/recognize_bytes?recognize_vehicle=1&country=us&secret_key=sk_3218410f6788f82ff8314df9'
		r = requests.post(url, data = img_base64)
		response = r.json() 
		return Response(response)

class ViewSetPlacas(viewsets.ModelViewSet):
	queryset = Placa.objects.all()
	serializer_class = PlacaSerializer