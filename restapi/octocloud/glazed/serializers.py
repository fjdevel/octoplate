from rest_framework import serializers
from .models import ImageUpload,Placa

class ImageUploadSerializer(serializers.ModelSerializer):
	class Meta:
		model = ImageUpload
		fields = '__all__'

class PlacaSerializer(serializers.ModelSerializer):
	class Meta:
		model = Placa
		fields = '__all__'