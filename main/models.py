
import uuid
from django.db import models

class Product(models.Model):
    name = models.CharField(max_length=255)            # name (CharField)
    price = models.IntegerField()                      # price (IntegerField)
    description = models.TextField(blank=True)         # description (TextField)
    thumbnail = models.URLField(blank=True, null=True) # thumbnail (URLField)
    category = models.CharField(max_length=100, blank=True)  # category (CharField)
    is_featured = models.BooleanField(default=False)   # is_featured (BooleanField)
    
    
    def __str__(self):
        return self.name
    

        

