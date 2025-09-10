Jelaskan bagaimana cara kamu mengimplementasikan checklist di atas secara step-by-step (bukan hanya sekadar mengikuti tutorial).
Jawab : 
- Membuat sebuah proyek Django baru -> (Sebelum itu jangan lupa mengikuti tutorial 0 karena kita memperlukan requirements.txt, env, dan env prod untuk menjalankan proyek django) Pertama kita bisa membuat direktori terlebih dahulu lalu buat virtual environment dan jangan lupa untuk mengaktifkannya. Selanjutanya saya menyiapkan Dependencies dan menginstallnya. Seperti sebelumnya saya sudah membuat .env yang berisikan 'Production=false' dan .env.prod yang berisikan kredensial yang diberikan melalui email saya. jangan lupa juga untuk mengubah dan menambahkan isi dari file settings.py yang berada di dalam repository 'football_shop'.

- Membuat aplikasi dengan nama main pada proyek tersebut -> Pertama, sebelumnnya saya sudah mengaftikan virtual environment (kalau belum jangan lupa diaktifkan) sehingga saya hanya perlu menjalankan command 'python manage.py startapp main' yang akan membuat direktori baru bernama main. yang terakhir saya harus memasukan direktori main di dalam file 'settings.py' dengan menambah string "main" di variable; "INSTALLED_APPS".

- Proses routing -> Saya mengisi file 'urls.py' yang sudah berada pada 'main', file tersebut berisikan sesuai yang diterakan oleh tutorial 1. Saya juga mengedit file 'urls.py' yang berada di repository 'football_shop' dengan mengarahkan semua requestnya ke file 'urls.py' yang ada di dalam 'main'
  
- Mmebuat model pada aplikasi main dengan nama Product dan memiliki atribut wajib sebagai berikut -> saya mengisi file 'model.py' dengan menambahkan class yang bernama Product yang memilki atribut-atribut wajib yang sesuai pada tugas 2:
  1. name (CharField) → digunakan untuk menyimpan nama produk. CharField cocok dipakai karena nama produk biasanya berupa teks pendek dengan jumlah karakter terbatas.
  2. price (IntegerField) → digunakan untuk menyimpan harga produk dalam bentuk angka bulat. IntegerField dipilih supaya bisa dilakukan operasi aritmetika (misalnya perhitungan total harga).
  3. description (TextField) → digunakan untuk menyimpan deskripsi produk. TextField dipakai karena teks bisa panjang (misalnya penjelasan detail produk).
  4. thumbnail (URLField) → digunakan untuk menyimpan tautan (URL) gambar produk. Dengan URLField, Django bisa otomatis melakukan validasi apakah string yang dimasukkan berbentuk URL yang valid.
  5. category (CharField) → digunakan untuk menyimpan kategori produk. CharField cocok karena biasanya kategori berupa teks pendek, seperti “Baju”, “Celana”, atau “Aksesoris”.
  6. is_featured (BooleanField) → digunakan untuk menyimpan status apakah produk tersebut termasuk produk unggulan atau tidak (True/False).

- Membuat sebuah fungsi pada views.py untuk dikembalikan ke dalam sebuah template HTML yang menampilkan nama aplikasi serta nama dan kelas. -> Saya melakukan dengan membuat sebuah fungsi home (namanya boleh bebas) yang akan mengirim data dari file 'views.py' ke template html (main.html).
- 
- Melakukan deployment ke PWS terhadap aplikasi yang sudah dibuat sehingga nantinya dapat diakses oleh teman-temanmu melalui Internet. -> Link PWS: https://rousan-chandra-ikearousan.pbp.cs.ui.ac.id/
- 
- Jangan lupa setelah melakukan semua ini, saya selalu melakukan push ke repositori Github dan PWS kalau ada update terbaru. dan juga di deploy juga di pws agar proyek saya bisa diliat untuk semua orang.
