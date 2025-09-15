from django.shortcuts import render, redirect, get_object_or_404
from main.forms import ProductForm
from main.models import Product
from django.http import HttpResponse
from django.core import serializers
# Create your views here.


def home(request):
    product_list = Product.objects.all()
    context = {
        'npm' : '2406435894',
        'student_name': 'Rousan Chandra Syahbunan',
        'class': 'PBP B',
        'product_list': product_list,
    }
    return render(request, 'main.html', context)

def show_xml(request):
    Product_list = Product.objects.all()
    xml_data = serializers.serialize("xml",  Product_list)
    return HttpResponse(xml_data, content_type="application/xml")

def show_json(request):
    Product_list =  Product.objects.all()
    json_data = serializers.serialize("json",  Product_list)
    return HttpResponse(json_data, content_type="application/json")

def create_product(request):
    form = ProductForm(request.POST or None)

    if form.is_valid() and request.method == "POST":
        form.save()
        return redirect('main:home')

    context = {'form': form}
    return render(request, "create_product.html", context)

def show_product(request, id):
    product = get_object_or_404(Product, pk=id)

    context = {
        'product': product
    }

    return render(request, "product_detail.html", context)


def show_xml_by_id(request, product_id):
   try:
       news_item = Product.objects.filter(pk=product_id)
       xml_data = serializers.serialize("xml", news_item)
       return HttpResponse(xml_data, content_type="application/xml")
   except Product.DoesNotExist:
       return HttpResponse(status=404)

def show_json_by_id(request, product_id):
   try:
       news_item = Product.objects.get(pk=product_id)
       json_data = serializers.serialize("json", [news_item])
       return HttpResponse(json_data, content_type="application/json")
   except Product.DoesNotExist:
       return HttpResponse(status=404)
