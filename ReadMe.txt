Submission1 JetPack Pro 

Pengujian halaman detail
1. Pengujian viewModel dengan unit test.
	a. Pengujian MovieViewModel
		Memastikan data MovieViewModel tidak null.
		Memastikan jumlah data Movie sesuai dengan yg diharapkan.
	b. Pengujian TvShowViewModel
		Memastikan data TvShowViewModel tidak null.
		Memastikan jumlah data TvShow sesuai dengan yg diharapkan.
	c. Pengujian DetailFilmViewModel
		Memastikan data model tidak null.
		Memastikan data model sesuai dengan skenario setUp().
2. Pengujian dengan instrumentation test :
	a. Menampilkan data pada DetailActivityTest
		Memastikan data yg ditampilkan pada DetailActivity sesuai dengan skenario getActivityIntent.
		Memastikan data text_title sesuai dengan title_movies[0] pada skenario.
		Memastikan data text_desc sesuai dengan movie_overview[0] pada skenario.
	b. Menampilkan MovieFragment
		Melakukan tindakan klik pada rv_movie.
		Memastikan ListView pada fragment berjumlah 10.
	c. Menampilkan TvShowFragment
		Melakukan tindakan klik pada rv_tv_show.
		Memastikan ListView pada fragment berjumlah 10.
