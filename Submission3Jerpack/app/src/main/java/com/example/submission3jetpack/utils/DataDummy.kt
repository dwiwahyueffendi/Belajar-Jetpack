package com.example.submission3jetpack.utils

import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.data.source.remote.response.GenresItem
import com.example.submission3jetpack.data.source.remote.response.GenresMovieItem
import com.example.submission3jetpack.data.source.remote.response.ResultsMovieItem
import com.example.submission3jetpack.data.source.remote.response.ResultsTvShowItem

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        return listOf(
                MovieEntity(
                        "458576",
                        "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                        "Monster Hunter",
                        "/8tNX8s3j1O0eqilOQkuroRLyOZA.jpg",
                        "Fantasy,  Action, Adventure",
                        "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                        104,
                        "2020-12-03",
                        7.3,
                        "Behind our world, there is another.",
                        false
                ),
                MovieEntity(
                        "464052",
                        "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                        "Wonder Woman 1984",
                        "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
                        "Fantasy, Action, Adventure",
                        "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                        152,
                        "2020-12-16",
                        6.9,
                        "A new era of wonder begins.",
                        false
                ),
                MovieEntity(
                        "508442",
                        "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                        "Soul",
                        "/kf456ZqeC45XTvo6W9pW5clYKfQ.jpg",
                        "Family, Animation, Comedy, Drama, Music, Fantasy",
                        "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                        101,
                        "2020-12-25",
                        8.3,
                        "Is all this living really worth dying for?",
                        false
                ),
                MovieEntity(
                        "522444",
                        "/95S6PinQIvVe4uJAd82a2iGZ0rA.jpg",
                        "Black Water: Abyss",
                        "/fRrpOILyXuWaWLmqF7kXeMVwITQ.jpg",
                        "Horror, Thriller, Adventure",
                        "An adventure-loving couple convince their friends to explore a remote, uncharted cave system in the forests of Northern Australia. With a tropical storm approaching, they abseil into the mouth of the cave, but when the caves start to flood, tensions rise as oxygen levels fall and the friends find themselves trapped. Unknown to them, the storm has also brought in a pack of dangerous and hungry crocodiles.",
                        98,
                        "2020-07-09",
                        5.1,
                        "Descend into fear",
                        false
                ),
        )
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        return listOf(
                TvShowEntity(
                        "114695",
                        "/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg",
                        "Marvel Studios: Legends",
                        "/iqmJfU6DkqJra9PqIepaOJbzfa1.jpg",
                        "Documentary",
                        "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.",
                        "2021-01-08",
                        7.7,
                        "As the universe expands, explore the stories of those destined to become legends.",
                        false
                ),
                TvShowEntity(
                        "117422",
                        "/gr4mvVThwX2lXajmScgzLKYcccS.jpg",
                        "Dos vidas",
                        "/nHo00WxAVUtnalEkIOJrPUOrkBL.jpg",
                        "Soap",
                        "The story of Julia, a woman currently living out the life that her mother and future husband have planned for her. But just as she is about to get married, she discovers a great family secret that will change her forever. On the verge of a nervous breakdown, she decides to get away and finds refuge in a secluded town in the mountains of Madrid where she will have a complicated mission: to take control of her own destiny.",
                        "2021-01-25",
                        0.0,
                        "",
                        false
                ),
                TvShowEntity(
                        "1399",
                        "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                        "Game of Thrones",
                        "/suopoADq0k8YZr4dQXcU6pToj6s.jpg",
                        "Sci-Fi & Fantasy, Drama, Action & Adventure",
                        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                        "2011-04-17",
                        8.4,
                        "Winter Is Coming",
                        false
                ),
                TvShowEntity(
                        "85271",
                        "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                        "Marvel Studios: Legends",
                        "/uro2Khv7JxlzXtLb8tCIbRhkb9E.jpg",
                        "Action & Adventure, Drama, Sci-Fi & Fantasy",
                        "Maggie has returned with a story she is not ready to share, even when her past catches up to her. Negan’s safety is at stake again. Daryl and Maggie fight an unseen and unknown threat.",
                        "2010-10-31",
                        8.0,
                        "Fight the dead. Fear the living.",
                        false
                ),
        )
    }

    fun generateDetailMovie(): MovieEntity {
        return MovieEntity(
                "458576",
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Monster Hunter",
                "/8tNX8s3j1O0eqilOQkuroRLyOZA.jpg",
                "Fantasy, Action, Adventure",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                104,
                "2020-12-03",
                7.3,
                "Behind our world, there is another.",
                false
        )
    }

    fun generateDetailTvShow(): TvShowEntity {
        return TvShowEntity(
                "114695",
                "/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg",
                "Marvel Studios: Legends",
                "/iqmJfU6DkqJra9PqIepaOJbzfa1.jpg",
                "Documentary",
                "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.",
                "2021-01-08",
                7.7,
                "As the universe expands, explore the stories of those destined to become legends.",
                false
        )
    }

    fun generateRemoteDummyMovies(): List<ResultsMovieItem> {
        return listOf(
                ResultsMovieItem(
                        "Monster Hunter",
                        "/8tNX8s3j1O0eqilOQkuroRLyOZA.jpg",
                        listOf(
                                GenresMovieItem(
                                        "Fantasy", 14
                                ),
                                GenresMovieItem(
                                        "Action", 28
                                ),
                                GenresMovieItem(
                                        "Adventure", 12
                                )
                        ),
                        "458576",
                        "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                        104,
                        "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                        "2020-12-03",
                        7.3,
                        "Behind our world, there is another."
                ),
                ResultsMovieItem(
                        "Wonder Woman 1984",
                        "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
                        listOf(
                                GenresMovieItem(
                                        "Fantasy", 14
                                ),
                                GenresMovieItem(
                                        "Action", 28
                                ),
                                GenresMovieItem(
                                        "Adventure", 12
                                )
                        ),
                        "464052",
                        "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                        152,
                        "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                        "2020-12-16",
                        6.9,
                        "A new era of wonder begins.",
                ),
                ResultsMovieItem(
                        "Soul",
                        "/kf456ZqeC45XTvo6W9pW5clYKfQ.jpg",
                        listOf(
                                GenresMovieItem(
                                        "Family", 10751
                                ),
                                GenresMovieItem(
                                        "Animation", 16
                                ),
                                GenresMovieItem(
                                        "Comedy", 35
                                ),
                                GenresMovieItem(
                                        "Drama", 18
                                ),
                                GenresMovieItem(
                                        "Music", 10402
                                ),
                                GenresMovieItem(
                                        "Fantasy", 14
                                )
                        ),
                        "508442",
                        "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                        101,
                        "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                        "2020-12-25",
                        8.3,
                        "Is all this living really worth dying for?",
                ),
                ResultsMovieItem(
                        "Black Water: Abyss",
                        "/fRrpOILyXuWaWLmqF7kXeMVwITQ.jpg",
                        listOf(
                                GenresMovieItem(
                                        "Horror", 27
                                ),
                                GenresMovieItem(
                                        "Thriller", 53
                                ),
                                GenresMovieItem(
                                        "Adventure", 12
                                ),
                                GenresMovieItem(
                                        "Mystery", 9648
                                )
                        ),
                        "522444",
                        "An adventure-loving couple convince their friends to explore a remote, uncharted cave system in the forests of Northern Australia. With a tropical storm approaching, they abseil into the mouth of the cave, but when the caves start to flood, tensions rise as oxygen levels fall and the friends find themselves trapped. Unknown to them, the storm has also brought in a pack of dangerous and hungry crocodiles.",
                        98,
                        "/95S6PinQIvVe4uJAd82a2iGZ0rA.jpg",
                        "2020-07-09",
                        5.1,
                        "Descend into fear"
                )

        )
    }

    fun generateRemoteDummyTvShows(): List<ResultsTvShowItem> {
        return listOf(
                ResultsTvShowItem(
                        "/iqmJfU6DkqJra9PqIepaOJbzfa1.jpg",
                        listOf(
                                GenresItem(
                                        "Documentary", 99
                                )
                        ),
                        "114695",
                        "2021-01-08",
                        "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.",
                        "/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg",
                        7.7,
                        "Marvel Studios: Legends",
                        "As the universe expands, explore the stories of those destined to become legends."
                ),
                ResultsTvShowItem(
                        "/nHo00WxAVUtnalEkIOJrPUOrkBL.jpg",
                        listOf(
                                GenresItem(
                                        "Soap", 10766
                                )
                        ),
                        "117422",
                        "2021-01-25",
                        "The story of Julia, a woman currently living out the life that her mother and future husband have planned for her. But just as she is about to get married, she discovers a great family secret that will change her forever. On the verge of a nervous breakdown, she decides to get away and finds refuge in a secluded town in the mountains of Madrid where she will have a complicated mission: to take control of her own destiny.",
                        "/gr4mvVThwX2lXajmScgzLKYcccS.jpg",
                        0.0,
                        "Dos vidas",
                        ""
                ),
                ResultsTvShowItem(
                        "/suopoADq0k8YZr4dQXcU6pToj6s.jpg",
                        listOf(
                                GenresItem(
                                        "Sci-Fi & Fantasy", 10765
                                ),
                                GenresItem(
                                        "Drama", 18
                                ),
                                GenresItem(
                                        "Action & Adventure", 10759
                                )
                        ),
                        "1399",
                        "2011-04-17",
                        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                        "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                        8.4,
                        "Game of Thrones",
                        "Winter Is Coming"
                ),
                ResultsTvShowItem(
                        "/uro2Khv7JxlzXtLb8tCIbRhkb9E.jpg",
                        listOf(
                                GenresItem(
                                        "Sci-Fi & Fantasy", 10765
                                ),
                                GenresItem(
                                        "Mystery", 9648
                                ),
                                GenresItem(
                                        "Drama", 18
                                )
                        ),
                        "85271",
                        "2010-10-31",
                        "Maggie has returned with a story she is not ready to share, even when her past catches up to her. Negan’s safety is at stake again. Daryl and Maggie fight an unseen and unknown threat.",
                        "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg\"",
                        8.0,
                        "Marvel Studios: Legends",
                        "Fight the dead. Fear the living.",
                )
        )
    }

    fun generateRemoteDetailMovie(): ResultsMovieItem {
        return ResultsMovieItem(
                "Monster Hunter",
                "/8tNX8s3j1O0eqilOQkuroRLyOZA.jpg",
                listOf(
                        GenresMovieItem(
                                "Fantasy", 14
                        ),
                        GenresMovieItem(
                                "Action", 28
                        ),
                        GenresMovieItem(
                                "Adventure", 12
                        )
                ),
                "458576",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                104,
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "2020-12-03",
                7.3,
                "Behind our world, there is another."
        )
    }

    fun generateRemoteDetailTvShow(): ResultsTvShowItem {
        return ResultsTvShowItem(
                "/iqmJfU6DkqJra9PqIepaOJbzfa1.jpg",
                listOf(
                        GenresItem(
                                "Documentary", 99
                        )
                ),
                "114695",
                "2021-01-08",
                "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.",
                "/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg",
                7.7,
                "Marvel Studios: Legends",
                "As the universe expands, explore the stories of those destined to become legends."
        )
    }
}