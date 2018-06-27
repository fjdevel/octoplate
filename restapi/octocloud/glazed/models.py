from django.db import models

# Create your models here.

class ImageUpload(models.Model):
	created = models.DateTimeField(auto_now_add=True)
	datafile = models.FileField(upload_to='uploads/%Y/%m/%d/')