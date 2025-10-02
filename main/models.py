
import uuid
from django.db import models
from django.contrib.auth.models import User

class Product(models.Model):
    CATEGORY_CHOICES = [
        ('bola sepak', 'Bola Sepak'),
        ('bola latihan', 'Bola Latihan'),
        ('pakaian', 'Pakaian'),
        ('sepatu sepak bola', 'Sepatu Sepak Bola'),
        ('aksesoris', 'Aksesoris'),
        ('gawang', 'Gawang'),
        ('budget', 'Budget'),
    ]
    user = models.ForeignKey(User, on_delete=models.CASCADE, null=True) 
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    name = models.CharField(max_length=255)            
    price = models.IntegerField()                      
    description = models.TextField(blank=True)         
    thumbnail = models.URLField(blank=True, null=True) 
    category = models.CharField(max_length=20, choices=CATEGORY_CHOICES,default='update')  
    is_featured = models.BooleanField(default=False)  
     
    def __str__(self):
        return self.name
    
    # @property
    # def is_news_hot(self):
    #     return self.news_views > 20

    # def increment_views(self):
    #     self.news_views += 1
    #     self.save()

# class Employee(models.Model):
#     name = models.CharField(max_length=200)
#     umur = models.IntegerField()
#     persona = models.TextField(blank=True)