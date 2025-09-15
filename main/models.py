
import uuid
from django.db import models

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

    name = models.CharField(max_length=255)            # name (CharField)
    price = models.IntegerField()                      # price (IntegerField)
    description = models.TextField(blank=True)         # description (TextField)
    thumbnail = models.URLField(blank=True, null=True) # thumbnail (URLField)
    category = models.CharField(max_length=100, choices=CATEGORY_CHOICES,blank=True)  # category (CharField)
    is_featured = models.BooleanField(default=False)   # is_featured (BooleanField)

    
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