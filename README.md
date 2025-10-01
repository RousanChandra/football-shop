Rousan Chandra Syahbunan - 2406435894

Tautan PWS: https://pbp.cs.ui.ac.id/rousan.chandra/ikearousan
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


<details>
<Summary><b>Tugas 4</b></Summary>
  
Apa itu Django AuthenticationForm? Jelaskan juga kelebihan dan kekurangannya. 

Jawab:

AuthenticationForm adalah form bawaan Django (django.contrib.auth.forms.AuthenticationForm) yang dipakai untuk proses login (sesuai ppt). Form ini mengikat request + POST data, memanggil backend autentikasi (authenticate()), dan memberikan form.get_user() bila kredensial valid.

Kelebihan:
- Siap pakai, terintegrasi dengan sistem auth Django → hemat waktu.
- Validasi aman (tidak mengungkap apakah username ada secara eksplisit).
- Memberikan pesan error terstruktur dan mekanisme validasi yang konsisten, sehingga memudahkan debugging dan mengurangi kemungkinan bug pada proses login.

Kekurangan:
- UI default sangat sederhana — perlu kustomisasi template agar cocok dengan desain.
- Tidak mendukung skenario login non-standar (mis. OTP, phone-only login) tanpa membuat form kustom.

Apa perbedaan antara autentikasi dan otorisasi? Bagaiamana Django mengimplementasikan kedua konsep tersebut?

Jawab:

Autentikasi adalah proses memverifikasi identitas pengguna: memastikan bahwa entitas yang mencoba mengakses sistem benar-benar adalah siapa yang mereka klaim. Contoh autentikasi: login dengan username/password, autentikasi berbasis token, atau login menggunakan OAuth.

Otorisasi adalah proses menentukan hak dan wewenang pengguna yang telah terverifikasi: setelah kita tahu siapa pengguna, otorisasi menjawab apa yang boleh dia lakukan. Contoh otorisasi: apakah pengguna boleh melihat halaman admin, mengedit produk tertentu, atau menghapus data pengguna lain.

Perbedaan:
- Urutan autentikasi datang sebelum otorisasi. Kita harus mengetahui identitas (atau setidaknya bahwa identitas sudah terverifikasi) sebelum mengecek hak akses.
- Autentikasi fokus pada identitas, otorisasi fokus pada izin/akses.
- Data autentikasi mengandalkan kredensial (password, token), sedangkan data otorisasi mengandalkan role, permission, atribut objek, dan kebijakan aplikasi.

Implementasi Autentikasi di Django:

1. Model User
* django.contrib.auth.models.User adalah model bawaan yang menyimpan username, password (ter-hash), email, is_active, is_staff, is_superuser, dan lain-lain. Aplikasi juga dapat menggunakan custom user model yang ditentukan lewat AUTH_USER_MODEL.

2. Mekanisme Verifikasi
* Fungsi authenticate() menerima kredensial dan memeriksa backend autentikasi yang aktif. Jika valid, ia mengembalikan instance User.

      from django.contrib.auth import authenticate, login
    
      user = authenticate(request, username='alice', password='pw')
      if user is not None:
        login(request, user)  # menyimpan user ke session

4. Login & Session
* login(request, user) menaruh identitas pengguna dalam session server-side dan mengaitkan session id ke cookie sessionid di browser klien.
* request.user (middleware AuthenticationMiddleware) menyediakan akses ke objek user di view/template.

4. Forms Bawaan
* Django menyediakan AuthenticationForm (untuk login) dan UserCreationForm (untuk registrasi) yang memberikan validasi dasar dan integrasi dengan mekanisme auth.

Implementasi Otorisasi di Django:

1. Permission Bawaan
* Setiap model di Django secara default dapat memiliki permission seperti add, change, delete, dan view.
* Permission tersimpan di model Permission dan dapat diperiksa dengan user.has_perm('app_label.codename').

2. Atribut & Role Sederhana
* is_staff dan is_superuser adalah atribut cepat untuk menentukan akses administratif.
* is_superuser melewati pemeriksaan permission biasa (memberikan akses penuh).

3. Groups
* Objek Group mengelompokkan sekumpulan permission; user dapat diberi group untuk memudahkan manajemen hak akses.

4. Dekorator, Mixins, dan Helper
* @login_required memastikan view hanya diakses oleh user yang terautentikasi.
* @permission_required('app.codename') memeriksa permission sebelum menjalankan view.
* Class-based view menawarkan LoginRequiredMixin dan PermissionRequiredMixin.

Apa saja kelebihan dan kekurangan session dan cookies dalam konteks menyimpan state di aplikasi web?

Jawab:
1. Cookies (client-side)

Kelebihan:
* Mudah dibuat dan langsung dapat dibaca oleh browser/JavaScript (berguna untuk preferensi UI yang perlu diakses client-side).
* Tidak memerlukan penyimpanan server tambahan.
* Persisten: bisa diset max-age/expires untuk menyimpan preferensi antar-sesi.

Kekurangan:
* Kapasitas kecil (±4KB per cookie) dan jumlah cookie per domain dibatasi.
* Mudah dimanipulasi oleh client → tidak boleh dipercaya untuk data sensitif.
* Rentan XSS jika HttpOnly=False (script jahat bisa baca cookie).
* Dikirim ke server setiap request ke domain terkait → overhead bandwidth & potensi eksposur data.
* Perlu perlindungan CSRF/SameSite jika cookie dipakai untuk otentikasi.

2. Sessions (server-side; contoh: django.contrib.sessions)

Kelebihan:
* Data disimpan di server (DB/Redis/file), sehingga lebih aman untuk informasi sensitif (user id, shopping cart, token internal).
* Client hanya menyimpan session id (biasanya dalam cookie sessionid), sehingga risiko manipulasi data menurun.
* Fleksibel: bisa menyimpan struktur data kompleks tanpa batas cookie.

Kekurangan:
* Membutuhkan storage server (stateful) — menambah beban storage dan manajemen.
* Skalabilitas horizontal butuh shared session backend (DB/Redis) atau sticky sessions.
* Performa: baca/tulis session tiap request bisa menambah latency (tergantung backend).
* Jika session tidak dikelola baik, bisa menumpuk data kadaluwarsa (cleanup).

Apakah penggunaan cookies aman secara default dalam pengembangan web, atau apakah ada risiko potensial yang harus diwaspadai? Bagaimana Django menangani hal tersebut?

Jawab:

Cookie tidak aman secara default karena seluruh isinya disimpan di sisi klien dan selalu dikirim setiap kali ada request ke server. Kondisi ini menimbulkan sejumlah risiko serius, antara lain:

- Risiko penggunaan cookie:

1. XSS (Cross-Site Scripting) → cookie bisa dicuri lewat script jahat jika tidak diset HttpOnly.
2. CSRF (Cross-Site Request Forgery) → browser otomatis mengirim cookie, sehingga request berbahaya dari situs lain tetap tampak sah.
3. Session fixation → penyerang bisa memaksa korban menggunakan session id tertentu untuk mengambil alih akses.
4. Sniffing → cookie dapat disadap jika koneksi masih HTTP.
5. Manipulasi client-side → isi cookie bisa diubah langsung oleh pengguna jika tidak ditandatangani atau diverifikasi.

- Cara Django mencegah risiko tersebut:
1. Session server-side → data penting disimpan di server, klien hanya membawa session id.
2. Rotasi session otomatis saat login → mencegah session fixation.
3. CSRF protection → middleware dan token CSRF memastikan request hanya valid jika berasal dari aplikasi sah.
4. Penggunaan HTTPS dengan SESSION_COOKIE_SECURE dan CSRF_COOKIE_SECURE → melindungi dari sniffing.
5. Cookie flags (HttpOnly, Secure, SameSite) → melindungi dari akses JavaScript berbahaya, memastikan cookie hanya lewat HTTPS, dan mengurangi risiko CSRF lintas situs.

Jelaskan bagaimana cara kamu mengimplementasikan checklist di atas secara step-by-step (bukan hanya sekadar mengikuti tutorial).

Jawab:

1. Mengimplementasikan fungsi registrasi, login, dan logout untuk memungkinkan pengguna mengakses aplikasi sebelumnya sesuai dengan status login/logoutnya. ->

Bagi jadi tiga:
- (Sebelumnnya saya sudah mengaktifkan env) Diawal dengan saya membuka views.py yang ada pada subdirektori main pada proyek saya. Lalu menambahkan import UserCreationForm dan messages. Tambahkan fungsi register di bawah ini ke dalam views.py (Sesuai tutorial 3). Selanjutnya memuatlah berkas HTML baru dengan nama register.html pada direktori main/templates. Jangan lupa menambahkan import fungsi register dan path url register di urls.py di main.
  
- (hampir sama kayak request) Diawal dengan saya membuka lagi views.py yang ada pada subdirektori main pada proyek saya. Lalu menambahkan import authenticate, login, dan AuthenticationForm di views.py. Selanjutnya menambahkan fungsi login_user ke dalam views.py. Selanjutnya saya membuat berkas HTML baru dengan nama login.html pada direktori main/templates. Jangan lupa menambahkan import fungsi login_user dan path url login_user di urls.py di main.
  
- Diawal dengan saya membuka lagi views.py yang ada pada subdirektori main pada proyek saya. Lalu menambahkan import logout di views.py. lalu menambahkan fungsi logout_user di bawah ini ke dalam fungsi views.py. Selanjutnya saya membuat berkas HTML baru dengan nama login.html pada direktori main/templates. Jangan lupa menambahkan import fungsi logout_user dan path url logout_user di urls.py di main.

2. Membuat dua (2) akun pengguna dengan masing-masing tiga (3) dummy data menggunakan model yang telah dibuat sebelumnya untuk setiap akun di lokal. -> 
Saya telah membuat 2 akun pengguna dan masing-masing 3 produk langsung melalui antarmuka (localhost atau pws) pada environment. Dengan cara saya membuat 1 akun dulu dari request dan login ke akun tersebut. Lalu saya tinggal membuat 3 produk yang saya inginkan (maaf kak, saya gak tau perlu saya jelasin juga contoh2nya. karena ini ngisinya langsung di website, apa saya perlu jelasin contoh2nya juga atau tidak) contohnya saya membuat baju MU, dengan harga 35.000, deksripsi (fans hebat), dan sebagainnya. Setelah membuat 3 produk dari
akun yang saya pakai. Saya logout dari akun dan membuat akun baru lagi. Setelah itu sama seperti sebelumnnya saya login dan membuat 3 produk yang sesuai keinginan saya (dummy).

3. Menghubungkan model Product dengan User dan menampilkan detail informasi pengguna yang sedang logged in seperti username dan menerapkan cookies seperti last_login pada halaman utama aplikasi (saling berhubungan) ->

Membuka file models.py pada subdirektori main, kemudian tambahkan from django.contrib.auth.models import User. Lalu pada model Product yang sudah dibuat, tambahkan user = models.ForeignKey(User, on_delete=models.CASCADE, null=True). jangan lupa setelah edit model, jalankan python manage.py makemigrations dan python manage.py mirgrate. Selanjutnya membuka kembali views.py yang ada pada subdirektori main, dan ubah potongan kode pada fungsi create_product (sesuai tutorial 3 tapi namanya sesuai direktori saya).

Jangan lupa untuk memodifikasi home(fungsi show_main saya). Saya menambahkan dengan context username = request.user.username dan juga menampilkan last_login dari cookie yang diset saat login.Setelah itu, saya menambahkan filter untuk produk saya sendiri, semua produk di berkas template (sekalian username sama last_login). Oh iya, tambahkan sebuah author untuk mengindetifikasi siapa yang membuat produk tersebut.


</details>

<details>
<Summary>Tugas 5</Summary>
  
Jika terdapat beberapa CSS selector untuk suatu elemen HTML, jelaskan urutan prioritas pengambilan CSS selector tersebut!

Jawab: 
- !important (catatan: penggunaan sebaiknya minimal)
- Inline style pada elemen (style="...")
- Selector dengan ID (#id) → specificity: 0,1,0,0
- Selector dengan class, attribute, pseudo-class (.class, [attr], :hover) → specificity: 0,0,1,0
- Selector dengan element/tag atau pseudo-element (div, p, ::before) → specificity: 0,0,0,1
- Jika specificity sama → yang didefinisikan belakangan (source order) menang.

Mengapa responsive design menjadi konsep yang penting dalam pengembangan aplikasi web? Berikan contoh aplikasi yang sudah dan belum menerapkan responsive design, serta jelaskan mengapa!

Jawab:

Penting karena sebagian besar pengguna mengakses web melalui perangkat mobile → UX harus baik di semua ukuran layar, SEO & Core Web Vitals: Google mengutamakan mobile-friendly, Meningkatkan konversi & aksesibilitas.

Contoh:
- Aplikasi yang sudah responsive: Google, Twitter, Medium — tata letak fleksibel, menu mobile, gambar responsif.
- Aplikasi yang kurang responsive: website lama pemerintahan / UKM yang dibuat hanya untuk desktop — tampil berantakan di mobile, tombol sulit diklik, layout horizontal memaksa scroll ke samping.

Kenapa contoh tersebut berbeda: responsive design membutuhkan breakpoints, fluid grids, dan testing across devices — banyak aplikasi lama tidak dioptimalkan karena waktu/keterbatasan budget.

Jelaskan perbedaan antara margin, border, dan padding, serta cara untuk mengimplementasikan ketiga hal tersebut!

Jawab:

Margin: ruang di luar border (mengatur jarak antar elemen). Contoh: margin: 16px;

Border: garis di sekeliling elemen (ketebalan, style, warna). Contoh: border: 1px solid #ccc;

Padding: ruang di dalam border antara content dan border (mengatur "jarak dalam"). Contoh: padding: 8px 12px;

[margin] [border] [padding] [ content ]
Contoh implementasi:

    .card {
        margin: 20px;
        border: 1px solid rgba(255,255,255,0.08);
        padding: 24px;
      }

Jelaskan konsep flex box dan grid layout beserta kegunaannya!

Jawab:

Flexbox (Flexible Box):
- Layout 1-dimensional (baris atau kolom).
- Berguna untuk: navbar, menu, card-row, alignment horizontal/vertical sederhana.
- Properti: display:flex; flex-direction; justify-content; align-items; gap; flex-wrap; flex-grow

Grid Layout (CSS Grid):
- Layout 2-dimensional (baris & kolom).
- Berguna untuk: grid gallery, komplek layout halaman (kanan, kiri, header, footer).
- Properti: display:grid; grid-template-columns; grid-template-rows; gap; grid-auto-flow;

Jelaskan bagaimana cara kamu mengimplementasikan checklist di atas secara step-by-step (bukan hanya sekadar mengikuti tutorial)!

Jawab:

1. Persiapan
- Siapkan model Product (title, content, thumbnail, category, is_featured, user, created_at, views).
- Buat ProductForm (ModelForm) untuk create & edit.

2. Views & URLs
- Buat view create, edit, delete, detail, list.
- Tambahkan url patterns pada main/urls.py.
- Pastikan edit & delete hanya boleh oleh owner (if product.user != request.user).

3. Templates
- base.html buat layout dasar & include static/css/cosmic.css. Pastikan <body> punya class theme (cosmic-page jika ingin global).
- product_list.html menampilkan placeholder jika kosong: {% if not product_list %} → show image + message + CTA.
- card_product.html buat desain card unik (tidak copy tutorial) dan tambahkan tombol Edit & Delete (form POST untuk delete).
- product_create.html, product_edit.html, product_detail.html kustomisasi sesuai tema (cosmic).

4. Styling
- Buat static/css/cosmic.css → background gradient, card blur, input dark, tombol neon.
- Untuk form fields, override default input style di .cosmic-card input, textarea, select { ... } supaya field tidak muncul putih.

5. Responsiveness
- Gunakan Tailwind (utility) atau media queries: grid berubah kolom pada breakpoints (sm/md/lg).
- Navbar responsive: desktop horizontal, mobile hamburger + slide-down menu.


</details>

