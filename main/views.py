from django.shortcuts import render

# Create your views here.
from .models import Product


def home(request):
    context = {
        'npm' : '2406435894',
        'student_name': 'Rousan Chandra Syahbunan',
        'class': 'PBP B',
        'product_name': 'Bola Adidas Tango',
        'price': 350000,
        'description': 'Bola sepak original Adidas Tango dengan kualitas tinggi, cocok untuk pertandingan maupun latihan.',
        'category': 'Peralatan Olahraga',
        'is_featured': True,
        'stock': 10
    }
    return render(request, 'main.html', context)
