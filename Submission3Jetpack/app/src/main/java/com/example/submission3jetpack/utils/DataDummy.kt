package com.example.submission3jetpack.utils

import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.data.source.remote.response.ListMovieResponse
import com.example.submission3jetpack.data.source.remote.response.ListTvShowResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                "578701",
                "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                "Those Who Wish Me Dead",
                "/iDdpiUnCeXvBmrkBFpL6lKsZt33.jpg",
                "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
                "2021-05-05",
                "7.2",
                false
            ),
            MovieEntity(
                "464052",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "Wonder Woman 1984",
                "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                "2020-12-16",
                "6.9",
                false
            ),
            MovieEntity(
                "508442",
                "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                "Soul",
                "/kf456ZqeC45XTvo6W9pW5clYKfQ.jpg",
                "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                "2020-12-25",
                "8.3",
                false
            ),
            MovieEntity(
                "458576",
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Monster Hunter",
                "/8tNX8s3j1O0eqilOQkuroRLyOZA.jpg",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "2020-12-03",
                "7.3",
                false
            ),
            MovieEntity(
                "522444",
                "/95S6PinQIvVe4uJAd82a2iGZ0rA.jpg",
                "Black Water: Abyss",
                "/fRrpOILyXuWaWLmqF7kXeMVwITQ.jpg",
                "An adventure-loving couple convince their friends to explore a remote, uncharted cave system in the forests of Northern Australia. With a tropical storm approaching, they abseil into the mouth of the cave, but when the caves start to flood, tensions rise as oxygen levels fall and the friends find themselves trapped. Unknown to them, the storm has also brought in a pack of dangerous and hungry crocodiles.",
                "2020-07-09",
                "5.1",
                false
            ),
        )
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                "60735",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-10-07",
                "7.7",
                false
            ),
            TvShowEntity(
                "117422",
                "/gr4mvVThwX2lXajmScgzLKYcccS.jpg",
                "Dos vidas",
                "/nHo00WxAVUtnalEkIOJrPUOrkBL.jpg",
                "The story of Julia, a woman currently living out the life that her mother and future husband have planned for her. But just as she is about to get married, she discovers a great family secret that will change her forever. On the verge of a nervous breakdown, she decides to get away and finds refuge in a secluded town in the mountains of Madrid where she will have a complicated mission: to take control of her own destiny.",
                "2021-01-25",
                "0.0",
                false
            ),
            TvShowEntity(
                "114695",
                "/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg",
                "Marvel Studios: Legends",
                "/iqmJfU6DkqJra9PqIepaOJbzfa1.jpg",
                "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.",
                "2021-01-08",
                "7.7",
                false
            ),
            TvShowEntity(
                "1399",
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Game of Thrones",
                "/suopoADq0k8YZr4dQXcU6pToj6s.jpg",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "2011-04-17",
                "8.4",
                false
            ),
            TvShowEntity(
                "71712",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "The Good Doctor",
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "2017-09-25",
                "8.6",
                false
            ),
        )
    }

    fun generateDetailMovie(): MovieEntity {
        return MovieEntity(
            "578701",
            "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
            "Those Who Wish Me Dead",
            "/iDdpiUnCeXvBmrkBFpL6lKsZt33.jpg",
            "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
            "2021-05-05",
            "7.2",
            false
        )
    }

    fun generateDetailTvShow(): TvShowEntity {
        return TvShowEntity(
            "60735",
            "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "The Flash",
            "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "2014-10-07",
            "7.7",
            false
        )
    }

    fun generateRemoteDummyMovies(): List<ListMovieResponse> {
        return listOf(
            ListMovieResponse(
                "Those Who Wish Me Dead",
                "/iDdpiUnCeXvBmrkBFpL6lKsZt33.jpg",
                "578701",
                "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
                "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                "2021-05-05",
                "7.2",
            ),
            ListMovieResponse(
                "Monster Hunter",
                "/8tNX8s3j1O0eqilOQkuroRLyOZA.jpg",
                "458576",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "2020-12-03",
                "7.3"
            ),
            ListMovieResponse(
                "Wonder Woman 1984",
                "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
                "464052",
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "2020-12-16",
                "6.9"
            ),
            ListMovieResponse(
                "Soul",
                "/kf456ZqeC45XTvo6W9pW5clYKfQ.jpg",
                "508442",
                "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                "2020-12-25",
                "8.3"
            ),
            ListMovieResponse(
                "Black Water: Abyss",
                "/fRrpOILyXuWaWLmqF7kXeMVwITQ.jpg",
                "522444",
                "An adventure-loving couple convince their friends to explore a remote, uncharted cave system in the forests of Northern Australia. With a tropical storm approaching, they abseil into the mouth of the cave, but when the caves start to flood, tensions rise as oxygen levels fall and the friends find themselves trapped. Unknown to them, the storm has also brought in a pack of dangerous and hungry crocodiles.",
                "/95S6PinQIvVe4uJAd82a2iGZ0rA.jpg",
                "2020-07-09",
                "5.1",
            )
        )
    }

    fun generateRemoteDummyTvShows(): List<ListTvShowResponse> {
        return listOf(
            ListTvShowResponse(
                "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                "60735",
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "7.7",
                "The Flash"
            ),
            ListTvShowResponse(
                "/iqmJfU6DkqJra9PqIepaOJbzfa1.jpg",
                "114695",
                "2021-01-08",
                "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.",
                "/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg",
                "7.7",
                "Marvel Studios: Legends"
            ),
            ListTvShowResponse(
                "/nHo00WxAVUtnalEkIOJrPUOrkBL.jpg",
                "117422",
                "2021-01-25",
                "The story of Julia, a woman currently living out the life that her mother and future husband have planned for her. But just as she is about to get married, she discovers a great family secret that will change her forever. On the verge of a nervous breakdown, she decides to get away and finds refuge in a secluded town in the mountains of Madrid where she will have a complicated mission: to take control of her own destiny.",
                "/gr4mvVThwX2lXajmScgzLKYcccS.jpg",
                "0.0",
                "Dos vidas",
            ),
            ListTvShowResponse(
                "/suopoADq0k8YZr4dQXcU6pToj6s.jpg",
                "1399",
                "2011-04-17",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "8.4",
                "Game of Thrones"
            ),
            ListTvShowResponse(
                "/uro2Khv7JxlzXtLb8tCIbRhkb9E.jpg",
                "85271",
                "2010-10-31",
                "Maggie has returned with a story she is not ready to share, even when her past catches up to her. Negan’s safety is at stake again. Daryl and Maggie fight an unseen and unknown threat.",
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg\"",
                "8.0",
                "Marvel Studios: Legends"
            )
        )
    }

    fun generateRemoteDetailMovie(): ListMovieResponse {
        return ListMovieResponse(
            "Those Who Wish Me Dead",
            "/iDdpiUnCeXvBmrkBFpL6lKsZt33.jpg",
            "578701",
            "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
            "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
            "2021-05-05",
            "7.2",
        )
    }

    fun generateRemoteDetailTvShow(): ListTvShowResponse {
        return ListTvShowResponse(
            "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
            "60735",
            "2014-10-07",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "7.7",
            "The Flash"
        )
    }
}