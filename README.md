<details>
<Summary><b>Tugas 2</b></Summary>
Jelaskan bagaimana cara kamu mengimplementasikan checklist di atas secara step-by-step (bukan hanya sekadar mengikuti tutorial).

Jawab : 
- Membuat sebuah proyek Django baru -> (Sebelum itu jangan lupa mengikuti tutorial 0 karena kita memperlukan requirements.txt, env, dan env prod untuk menjalankan proyek django) Pertama kita bisa membuat direktori terlebih dahulu lalu buat virtual environment dan jangan lupa untuk mengaktifkannya. Selanjutanya saya menyiapkan Dependencies dan menginstallnya. Seperti sebelumnya saya sudah membuat .env yang berisikan 'Production=false' dan .env.prod yang berisikan kredensial yang diberikan melalui email saya. jangan lupa juga untuk mengubah dan menambahkan isi dari file settings.py yang berada di dalam repository 'football_shop'.

- Membuat aplikasi dengan nama main pada proyek tersebut -> Pertama, sebelumnnya saya sudah mengaftikan virtual environment (kalau belum jangan lupa diaktifkan) sehingga saya hanya perlu menjalankan command 'python manage.py startapp main' yang akan membuat direktori baru bernama main. yang terakhir saya harus memasukan direktori main di dalam file 'settings.py' dengan menambah string "main" di variable; "INSTALLED_APPS".

- Proses routing (kedua routing saya gabung kesini) -> Saya mengisi file 'urls.py' yang sudah berada pada 'main', file tersebut berisikan sesuai yang diterakan oleh tutorial 1. Saya juga mengedit file 'urls.py' yang berada di repository 'football_shop' dengan mengarahkan semua requestnya ke file 'urls.py' yang ada di dalam 'main'
  
- Mmebuat model pada aplikasi main dengan nama Product dan memiliki atribut wajib sebagai berikut -> saya mengisi file 'model.py' dengan menambahkan class yang bernama Product yang memilki atribut-atribut wajib yang sesuai pada tugas 2:
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

<Summary><b>Tugas 3</b></Summary>

Jelaskan mengapa kita memerlukan data delivery dalam pengimplementasian sebuah platform?


