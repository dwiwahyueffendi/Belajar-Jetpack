package com.example.myapplication.utils

import com.example.myapplication.data.local.ContentEntity
import com.example.myapplication.data.remote.response.MovieResponse
import com.example.myapplication.data.remote.response.TvShowResponse

object DataDummy {

    fun GenerateDataMovie(): List<MovieResponse> {
        val listMovie = ArrayList<MovieResponse>()

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            1,
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "https://image.tmdb.org/t/p/w500/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
            "2021-03-24",
            "Godzilla vs. Kong",
            "8.3"))

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/original/XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg",
            2,
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son\\'s murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking\\'s associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
            "Cold Pursuit",
            "2019-02-07",
             "5.7"))

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/original/7568G5PAdQweNfTiuwzlssOxueB.jpg",
            3,
            "Between personal obligations and training for his next big fight against an opponent with ties to his family\\'s past, Adonis Creed is up against the challenge of his life.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
            "2018-11-21",
            "Creed II",
            "6.9"))

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/original/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg",
            4,
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "2019-31-01",
            "Alita: Battle Angel",
            "7.2"))

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/original/4IWnPqNu34zY4ku3LQJw56MIHFc.jpg",
            5,
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother and true heir to the throne.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
            "2018-12-07",
            "Aquaman",
            "8.0"))

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/original/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpgc",
            6,
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock \\'n\\' roll band Queen in 1970. Hit songs become instant classics. When Mercury\\'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
            "2018-10-24",
            "Bohemian Rhapsody",
            "8.0"))

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/original/heyvaoVLGC8lcB4FFoz65EBI8xF.jpg",
            7,
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
            "2018-11-10",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "6.9"))

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/original/ngBFDOsx13sFXiMweDoL54XYknR.jpg",
            8,
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
            "2019-01-16",
            "Glass",
            "6.7"))

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/original/kbGO5mHPK7rh516MgAIJUQ9RvqD.jpg",
            9,
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "2018-04-05",
            "Avengers: Infinity War",
            "8.3"))

        listMovie.add(MovieResponse(
            "https://image.tmdb.org/t/p/original/h3KN24PrOheHVYs9ypuOIdFBEpX.jpg",
            10,
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
            "2010-03-10",
            "How to Train Your Dragon: The Hidden World",
            "7,8"))



        return listMovie
    }

    fun GenerateDataTvShow(): List<TvShowResponse> {
        val listTvShow = ArrayList<TvShowResponse>()

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
            11,
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            "2012-10-10",
            "Arrow",
            "6.6"))

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/hnK5vODlS1OIIF3Sw6T0RQyt0K3.jpg",
            12,
            "Sick, twisted, politically incorrect and Freakin\\' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he\\'s not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xtIFsv0Wpy29Bw7i8gUm1L9x6x8.jpg",
            "1999-01-31",
            "Family Guy",
            "7.0"))

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/rkRqvadAVWzdnrS6bdcUAyJtfpy.jpg",
            13,
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won\\'t be long before the world learns what Barry Allen has become…The Flash.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
            "2014-10-07",
            "The Flash",
            "7.0"))

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/sAzw6I1G9JUxm86KokIDdQeWtaq.jpg",
            14,
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
            "2019-02-15",
            "Doom Patrol",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg"))

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/igXpePfyVeuG50rvSVEay2u4I3R.jpg",
            15,
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku\\'s home. Together, they set off to find all seven and to grant her wish.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
            "1986-02-26",
            "Dragon Ball",
            "8.1"))

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg",
            16,
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'t just any ordinary kid, he\\'s a member of one of the world\\'s most infamous mage guilds: Fairy Tail.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
            "2017-05-06",
            "Fairy Tail",
            "6.5"))

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/xM8zPWNqwbgCZQNgOOH2YeM7Cu.jpg",
            17,
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night\\'s Watch, is all that stands between the realms of men and icy horrors beyond.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
            "2011-04-17",
            "Game of Thrones",
            "8.4"))

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/l0U4mNs2vp65AAbfH8v2ymij8T5.jpg",
            18,
            "Everyone knows the title Commissioner Gordon. He is one of the crime world\\'s greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon\\'s story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world\\'s most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
            "2014-10-12",
            "Gotham",
            "7.5"))

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/ofjZbud67zO2wxQ48VgMVnkECQu.jpg",
            19,
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
            "2019-03-28",
            "Hanna",
            "7.5"))

        listTvShow.add(TvShowResponse(
            "https://image.tmdb.org/t/p/original/ym20NYY99jNH0OzSg4TgLLGsQF9.jpg",
            20,
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
            "2005-03-27",
            "Grey\\'s Anatomy",
             "8.2"))



        return listTvShow
    }

    fun generateDataMovieDummy(): List<ContentEntity> {
        val listMovie = ArrayList<ContentEntity>()

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            1,
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "https://image.tmdb.org/t/p/w500/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
            "2021-03-24",
            "Godzilla vs. Kong",
            "8.3"))

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg",
            2,
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son\\'s murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking\\'s associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
            "Cold Pursuit",
            "2019-02-07",
            "5.7"))

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/7568G5PAdQweNfTiuwzlssOxueB.jpg",
            3,
            "Between personal obligations and training for his next big fight against an opponent with ties to his family\\'s past, Adonis Creed is up against the challenge of his life.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
            "2018-11-21",
            "Creed II",
            "6.9"))

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg",
            4,
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "2019-31-01",
            "Alita: Battle Angel",
            "7.2"))

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/4IWnPqNu34zY4ku3LQJw56MIHFc.jpg",
            5,
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother and true heir to the throne.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
            "2018-12-07",
            "Aquaman",
            "8.0"))

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpgc",
            6,
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock \\'n\\' roll band Queen in 1970. Hit songs become instant classics. When Mercury\\'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
            "2018-10-24",
            "Bohemian Rhapsody",
            "8.0"))

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/heyvaoVLGC8lcB4FFoz65EBI8xF.jpg",
            7,
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
            "2018-11-10",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "6.9"))

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/ngBFDOsx13sFXiMweDoL54XYknR.jpg",
            8,
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
            "2019-01-16",
            "Glass",
            "6.7"))

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/kbGO5mHPK7rh516MgAIJUQ9RvqD.jpg",
            9,
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "2018-04-05",
            "Avengers: Infinity War",
            "8.3"))

        listMovie.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/h3KN24PrOheHVYs9ypuOIdFBEpX.jpg",
            10,
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
            "2010-03-10",
            "How to Train Your Dragon: The Hidden World",
            "7,8"))

        return listMovie
    }

    fun generateDataTvShowDummy(): List<ContentEntity> {
        val listTvShow = ArrayList<ContentEntity>()

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
            11,
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            "2012-10-10",
            "Arrow",
            "6.6"))

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/hnK5vODlS1OIIF3Sw6T0RQyt0K3.jpg",
            12,
            "Sick, twisted, politically incorrect and Freakin\\' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he\\'s not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xtIFsv0Wpy29Bw7i8gUm1L9x6x8.jpg",
            "1999-01-31",
            "Family Guy",
            "7.0"))

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/sAzw6I1G9JUxm86KokIDdQeWtaq.jpg",
            13,
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
            "2019-02-15",
            "Doom Patrol",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg"))

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/igXpePfyVeuG50rvSVEay2u4I3R.jpg",
            14,
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku\\'s home. Together, they set off to find all seven and to grant her wish.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
            "1986-02-26",
            "Dragon Ball",
            "8.1"))

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg",
            15,
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'t just any ordinary kid, he\\'s a member of one of the world\\'s most infamous mage guilds: Fairy Tail.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
            "2017-05-06",
            "Fairy Tail",
            "6.5"))

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/rkRqvadAVWzdnrS6bdcUAyJtfpy.jpg",
            16,
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won\\'t be long before the world learns what Barry Allen has become…The Flash.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
            "2014-10-07",
            "The Flash",
            "7.0"))

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/xM8zPWNqwbgCZQNgOOH2YeM7Cu.jpg",
            17,
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night\\'s Watch, is all that stands between the realms of men and icy horrors beyond.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
            "2011-04-17",
            "Game of Thrones",
            "8.4"))

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/l0U4mNs2vp65AAbfH8v2ymij8T5.jpg",
            18,
            "Everyone knows the title Commissioner Gordon. He is one of the crime world\\'s greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon\\'s story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world\\'s most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
            "2014-10-12",
            "Gotham",
            "7.5"))

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/ym20NYY99jNH0OzSg4TgLLGsQF9.jpg",
            19,
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
            "2005-03-27",
            "Grey\\'s Anatomy",
            "8.2"))

        listTvShow.add(ContentEntity(
            "https://image.tmdb.org/t/p/original/ofjZbud67zO2wxQ48VgMVnkECQu.jpg",
            20,
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
            "2019-03-28",
            "Hanna",
            "7.5"))

        return listTvShow
    }
}