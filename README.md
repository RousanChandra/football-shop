<details>
<Summary><b>Tugas 2</b></Summary>
Jelaskan bagaimana cara kamu mengimplementasikan checklist di atas secara step-by-step (bukan hanya sekadar mengikuti tutorial).

Jawab : 
- Membuat sebuah proyek Django baru -> (Sebelum itu jangan lupa mengikuti tutorial 0 karena kita memperlukan requirements.txt, env, dan env prod untuk menjalankan proyek django) Pertama kita bisa membuat direktori terlebih dahulu lalu buat virtual environment dan jangan lupa untuk mengaktifkannya. Selanjutanya saya menyiapkan Dependencies dan menginstallnya. Seperti sebelumnya saya sudah membuat .env yang berisikan 'Production=false' dan .env.prod yang berisikan kredensial yang diberikan melalui email saya. jangan lupa juga untuk mengubah dan menambahkan isi dari file settings.py yang berada di dalam repository 'football_shop'.

- Membuat aplikasi dengan nama main pada proyek tersebut -> Pertama, sebelumnnya saya sudah mengaftikan virtual environment (kalau belum jangan lupa diaktifkan) sehingga saya hanya perlu menjalankan command 'python manage.py startapp main' yang akan membuat direktori baru bernama main. yang terakhir saya harus memasukan direktori main di dalam file 'settings.py' dengan menambah string "main" di variable; "INSTALLED_APPS".

- Proses routing (kedua routing saya gabung kesini) -> Saya mengisi file 'urls.py' yang sudah berada pada 'main', file tersebut berisikan sesuai yang diterakan oleh tutorial 1. Saya juga mengedit file 'urls.py' yang berada di repository 'football_shop' dengan mengarahkan semua requestnya ke file 'urls.py' yang ada di dalam 'main'
  
- Membuat model pada aplikasi main dengan nama Product dan memiliki atribut wajib sebagai berikut -> saya mengisi file 'model.py' dengan menambahkan class yang bernama Product yang memilki atribut-atribut wajib yang sesuai pada tugas 2:
  1. name (CharField) → digunakan untuk menyimpan nama produk. CharField cocok dipakai karena nama produk biasanya berupa teks pendek dengan jumlah karakter terbatas.
  2. price (IntegerField) → digunakan untuk menyimpan harga produk dalam bentuk angka bulat. IntegerField dipilih supaya bisa dilakukan operasi aritmetika (misalnya perhitungan total harga).
  3. description (TextField) → digunakan untuk menyimpan deskripsi produk. TextField dipakai karena teks bisa panjang (misalnya penjelasan detail produk).
  4. thumbnail (URLField) → digunakan untuk menyimpan tautan (URL) gambar produk. Dengan URLField, Django bisa otomatis melakukan validasi apakah string yang dimasukkan berbentuk URL yang valid.
  5. category (CharField) → digunakan untuk menyimpan kategori produk. CharField cocok karena biasanya kategori berupa teks pendek, seperti “Baju”, “Celana”, atau “Aksesoris”.
  6. is_featured (BooleanField) → digunakan untuk menyimpan status apakah produk tersebut termasuk produk unggulan atau tidak (True/False).

- Membuat sebuah fungsi pada views.py untuk dikembalikan ke dalam sebuah template HTML yang menampilkan nama aplikasi serta nama dan kelas. -> Saya melakukan dengan membuat sebuah fungsi home (namanya boleh bebas) yang akan mengirim data dari file 'views.py' ke template html (main.html).
  
- Melakukan deployment ke PWS terhadap aplikasi yang sudah dibuat sehingga nantinya dapat diakses oleh teman-temanmu melalui Internet. -> Link PWS: https://rousan-chandra-ikearousan.pbp.cs.ui.ac.id/
  
- Jangan lupa setelah melakukan semua ini, saya selalu melakukan push ke repositori Github dan PWS kalau ada update terbaru. dan juga di deploy juga di pws agar proyek saya bisa diliat untuk semua orang.

Buatlah bagan yang berisi request client ke web aplikasi berbasis Django beserta responnya dan jelaskan pada bagan tersebut kaitan antara urls.py, views.py, models.py, dan berkas html.

Jawab:
Client (Browser)  →  urls.py(yang bagian proyek)  →  Cek url (kalau url sesuai akan lanjut ke berikutnya, kalau url tidak sesuai maka akan error 404)  →  urls.py(yang bagian apliasi)  →  views.py  →  models.py  →  views.py  →  Berkas (main.html) →  Response ke Client (Browser)

urls.py: Mengecek pola URL, lalu mengarahkan request ke fungsi yang sesuai di views.py.
views.py: Menjalankan logika aplikasi. Mengambil data dari database lewat models.py, lalu kirim data ke template.
models.py: Definisi struktur data. Kalau views.py butuh data produk, ia akan query ke models.py.
Berkas (main.html): Tempat menampilkan data. views.py me-render data ke dalam template ini.
Response: HTML yang sudah jadi dikirim kembali ke browser.

Peran settings.py dalam proyek Django

Jawab:
- Menyimpan daftar aplikasi 'main' (INSTALLED_APPS).
- Mengatur database (engine, nama DB, user, password).
- Mengatur middleware (komponen yang memproses request/response sebelum sampai ke view).
- Menyimpan konfigurasi keamanan (secret key, debug mode, allowed hosts).
- Menentukan lokasi file statis (CSS, JS, gambar) dan template.
  
Cara kerja migrasi database di Django

Jawab: Semisalnya saya ingin ada perubahan pada model ataupun membuat model.py, struktur database otomatis berubah. Django nggak akan langsung ubah database sehingga kita perlu melakukan 'python manage.py makemigrations' untuk menghasilkan file migration (isi instruksi perubahan). Lalu jalankan 'python manage.py migrate' -> Django menerapkan perubahan itu ke database. jadi kegunaan migrasi sebagai sinkronisasi

Mengapa Django dipilih untuk pembelajaran awal?

Jawab: 
karena Django pakai pola Model–View–Template (MVT) yang jelas → mudah dipahami untuk dasar pengembangan. (Sayapun memahaminya dengan baik), lalu perlengkapan ada tools bawaan untuk database, autentikasi, routing, admin panel. Jadi saya bisa fokus ke logika, bukan ribet in bstal library tambahan. Dan juga populer banyak dipakai di perusahaan, jadi ilmu yang diajar berguna di dunia kerja serta Python lebih mudah dipelajari daripada bahasa lain, cocok untuk perkenalan framework web.

Apakah ada feedback untuk asisten dosen tutorial 1 yang telah kamu kerjakan sebelumnya?

Jawab: Penjelasan cukup jelas, saya sangat berterima kasih sudah diberikan cara memahami materinya dengan baik.

Terima kasih banyak kak.

</details>

<details>
<Summary><b>Tugas 3</b></Summary>

Jelaskan mengapa kita memerlukan data delivery dalam pengimplementasian sebuah platform?

Jawab: Dalam sebuah platform, data delivery itu penting banget karena dipakai buat ngirim data dari satu bagian sistem ke bagian lain. Bayangin aja kita punya aplikasi, pasti ada proses tuker data antara satu komponen dengan komponen lain biar aplikasinya jalan bener. Kalau nggak ada mekanisme ini, tiap bagian bakal jalan sendiri-sendiri tanpa bisa kerja sama. Biar gampang ditransfer, datanya butuh format yang terstruktur dan bisa dimengerti sama semua komponen. Dua format yang bakal saya pakai buat tugas 3 ini adalah XML sama JSON.
Sebagai contoh data delivery:
- XML biasanya dipakai di sistem lama atau enterprise karena fleksibel banget, lo bisa bikin tag sesuai kebutuhan. Cocok buat data yang rumit.
- JSON lebih simpel dan ringan karena isinya berbentuk key-value pairs. Makanya sekarang JSON lebih populer, apalagi di API modern dan aplikasi kekinian.
Jadi intinya, pake XML atau JSON bikin proses pengiriman data jadi lebih konsisten, efisien, dan gampang diintegrasiin. Hasilnya, platform bisa lebih gampang dikembangin, lebih fleksibel, dan jalan sebagai satu sistem utuh.

Menurutmu, mana yang lebih baik antara XML dan JSON? Mengapa JSON lebih populer dibandingkan XML?

Jawab: Menurut saya, JSON emang lebih baik dibanding XML. Soalnya struktur JSON itu lebih simpel, cuma pake key-value aja, mirip dictionary. Jadi waktu dibaca sama diproses, lebih gampang dan lebih cepet dipahami. Selain itu, ukuran file JSON juga biasanya lebih kecil karena tidak banyak tag buka-tutup kayak di XML, jadi lebih hemat storage sama bandwidth. XML sebenernya punya kelebihan juga, misalnya bisa dipake buat data yang kompleks dan ada fitur validasi lewat schema. Tapi di praktiknya, terutama buat API sama aplikasi web atau mobile, orang-orang lebih butuh format data yang ringan, gampang dibaca, dan gampang diproses. Itu sebabnya JSON jauh lebih populer sekarang. Sebagai contohnya waktu pembahasan bersama dosen, website yang menggunakan XML jarang ditemukan di zaman sekarang. Apalagi JSON udah langsung didukung di JavaScript sama banyak framework modern, jadi developer tidak perlu ribet lagi ngubah-ngubah format. Intinya, JSON lebih praktis, efisien, dan relevan sama kebutuhan zaman sekarang dibanding XML.

Jelaskan fungsi dari method is_valid() pada form Django dan mengapa kita membutuhkan method tersebut?

Jawab: Method is_valid() pada Django form adalah komponen krusial dalam validasi data input. Di Django, is_valid() itu dipake buat mengecek apakah data yang diinput user ke form udah sesuai sama aturan validasi yang saya set. Misalnya kita bikin form buat input data mahasiswa, di situ ada field nama, NPM, sama umur. Nah, kalau is_valid() return True, berarti datanya valid dan bisa diproses atau disimpan ke database. Ini sangat penting untuk Django. Karena kalau nggak ada validasi, data yang masuk bisa kacau atau bahkan meerusak sistem. Dengan is_valid(), kita aman dari input yang salah, bikin data di database lebih terjaga, dan sistem jadi lebih stabil. Jadi sebelum data masuk ke tahap berikutnya, harus lewat cek ini dulu.

Mengapa kita membutuhkan csrf_token saat membuat form di Django? Apa yang dapat terjadi jika kita tidak menambahkan csrf_token pada form Django? Bagaimana hal tersebut dapat dimanfaatkan oleh penyerang?

Jawab: Csrf_token digunakan sebagai pelindung ekstra di Django buat form. Token ini dipakai agar server bisa meyakinkan kalau request form bener-bener datang dari user lewat aplikasi kita, bukan dari situs lain yang coba menyerang.
Kalau kita tidak pake csrf_token, aplikasi bisa kena serangan CSRF (Cross-Site Request Forgery). Misalnya, user lagi login di aplikasi, terus buka website berbahaya yang diam-diam bikin request ke aplikasi kita. Kalau token nggak ada, request itu bisa aja lolos, padahal bukan user yang maksud. Serangannya bisa dipake buat hal-hal berbahaya, kayak mindahin data, ganti password, bahkan transaksi ilegal. Dengan csrf_token, setiap request punya kode unik yang harus cocok sama yang ada di server. Jadi, request palsu tidak bakal diterima. Makanya ini wajib untuk dipakai.

Jelaskan bagaimana cara kamu mengimplementasikan checklist di atas secara step-by-step (bukan hanya sekadar mengikuti tutorial).

Jawab: (Sebelum menambahkan empat fungsi views untuk data delivery, saya terlebih dahulu memastikan bahwa fungsi dasar create_product dan show_product sudah diimplementasi dengan proper di views.py, beserta routing URL yang sesuai) 
Tambahkan 4 fungsi views baru untuk melihat objek yang sudah ditambahkan dalam format XML, JSON, XML by ID, dan JSON by ID. ->  Untuk menambahkan 4 fungsi views.py, Saya memerlukan beberapa format sesuai yang ada di tutorial 2 lalu memodifikasinya sesuai dengan direktori tugas 2 saya.

Codingnya:

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
          product_item = Product.objects.filter(pk=product_id)
          xml_data = serializers.serialize("xml", product_item)
          return HttpResponse(xml_data, content_type="application/xml")
      except Product.DoesNotExist:
          return HttpResponse(status=404)

    def show_json_by_id(request, product_id):
      try:
         product_item = Product.objects.get(pk=product_id)
         json_data = serializers.serialize("json", [product_item])
         return HttpResponse(json_data, content_type="application/json")
       except Product.DoesNotExist:
         return HttpResponse(status=404)

Membuat routing URL untuk masing-masing views yang telah ditambahkan pada poin 1 -> Menambahkan URL routing yang sesuai di urls.py untuk masing-masing fungsi.

    from django.urls import path
    from main.views import home, show_product, create_product, show_xml, show_json, show_xml_by_id, show_json_by_id

    app_name = 'main'
      urlpatterns = [
          path('', home, name='home'),
          path('create-product/', create_product, name='create_product'),
          path('product/<str:id>/', show_product, name='show_product'),
          path('xml/', show_xml, name='show_xml'),
          path('json/', show_json, name='show_json'),
          path('xml/<str:product_id>/', show_xml_by_id, name='show_xml_by_id'),
          path('json/<str:product_id>/', show_json_by_id, name='show_json_by_id'),
      ] 

Membuat halaman yang menampilkan data objek model yang memiliki tombol "Add" yang akan redirect ke halaman form, serta tombol "Detail" pada setiap data objek model yang akan menampilkan halaman detail objek.  Membuat halaman form untuk menambahkan objek model pada app sebelumnya. Membuat halaman yang menampilkan detail dari setiap data objek model. Ketiganya saya gabung karena semuanya berhubungan langsung. 

-> Membuat berkas baru pada direktori main dengan nama forms.py untuk membuat struktur form yang dapat menerima data Product baru. Tambahkan kode tersebut di form.py. Lalu, sebelumnya saya sudah membuat fungsi dan path url create_product dan show_product sehingga yang perlu saya lakukan membuat berkas - berkas yang diperlukan untuk membuat create_product.html dan show_product.html yang berada di direktori main. Formatnya menyesuaikan kritea saya, misalnya kalau football_shop yang saya perlukan adalah nama, harga, dekripsi, jenis barang, dan sebagainya. Jangan lupa menambahkan {% csrf_token %} dan {{ form.as_table }} pada create_product.html.

{% csrf_token %} adalah token yang berfungsi sebagai security. Token ini di-generate secara otomatis oleh Django untuk mencegah serangan berbahaya.
{{ form.as_table }} adalah template tag yang digunakan untuk menampilkan fields form yang sudah dibuat pada forms.py sebagai table.

Tambahan hal penting, sebelumnya saya sudah membuat sebuah base.html yang berada pada folder template di direktori utama. ini berfungsi sebagai template dasar yang dapat digunakan sebagai kerangka umum untuk halaman web lainnya di dalam proyek. Dan untuk main.html yang berada di direktori main. Terdapat perubahan yaitu digunakan sebagai extend dari folder template berisi file base.html yang ada di direktori utama(football-shop). Hal ini juga berlaku untuk html yang lainnya seperti create_product.html dan show_product.html.

Sebelumnya saya sudah membuat base.html sebagai kerangka umum sehingga saya perlu menambahkan sebuah BASE_DIR / templates pada bagian DIRS di varible TEMPLATES di settings.py agar berkas base.html terdeteksi sebagai berkas template.

Terakhir, saya menambahkan entri url proyek pws saya pada CSRF_TRUSTED_ORIGINS tepat setelah local host.

Untuk SS Postman, saya hanya perlu mendownload postman sesuai yang ada di tutorial 2. Lalu menyalin url - url yang saya perlukan seperti pada foto dibawah ini.

Untuk git, seperti biasa saya hanya perlu add, commit dan push ke github saya ini.

Apakah ada feedback untuk asdos di tutorial 2 yang sudah kalian kerjakan?

Jawab: Untuk tutorial 2, saya memahami dengan baik. Hanya saja banyak sekali error saat di PWS dibandingkan saat saya di localhost. jadi jujur localhost saya lebih baik dijalankan dibanding pws saat tutorial 2.


4 foto hasil url postman:
<img width="1517" height="954" alt="image" src="https://github.com/user-attachments/assets/c57f11fc-1fdf-42d4-86ed-eae1424b06d5" />
<img width="1536" height="923" alt="Screenshot 2025-09-17 102046" src="https://github.com/user-attachments/assets/75ba7fec-1c24-4fca-bb0b-2616bb94523b" />
<img width="1510" height="861" alt="image" src="https://github.com/user-attachments/assets/bec411a0-aeea-4fbc-9a1b-c7a56b3faefc" />
<img width="1523" height="891" alt="image" src="https://github.com/user-attachments/assets/897a0623-d03d-4c7a-93b9-f5a305663c4e" />

</details>




