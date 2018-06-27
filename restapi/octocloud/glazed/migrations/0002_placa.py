# Generated by Django 2.0.6 on 2018-06-27 06:35

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('glazed', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Placa',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('reporte', models.BooleanField()),
                ('placa', models.CharField(max_length=10)),
                ('imagen', models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, to='glazed.ImageUpload')),
            ],
        ),
    ]