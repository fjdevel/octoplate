from django.db import models

# Create your models here.

class ImageUpload(models.Model):
	created = models.DateTimeField(auto_now_add=True)
	datafile = models.FileField(upload_to='uploads/%Y/%m/%d/')

class Placa(models.Model):
	reporte = models.BooleanField()
	imagen = models.ForeignKey('ImageUpload',null=True,on_delete=models.CASCADE)
	placa = models.CharField(max_length=10)