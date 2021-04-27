package com.example.movieappjetpack.data.dummy

import com.example.movieappjetpack.data.ContentEntity

object DataDummy {

    fun generateDummyMovie(): List<ContentEntity>{
        val movie = ArrayList<ContentEntity>()

        movie.add(ContentEntity(
            "11112",
            "Godzilla vs. Kong",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "2021-03-24",
            "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "8.3",
            "6.914.198",
            "https://www.themoviedb.org/movie/399566-godzilla-vs-kong"))
        movie.add(ContentEntity(
            "22221",
            "Chaos Walking",
            "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
            "2021-02-24",
            "https://image.tmdb.org/t/p/w500/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
            "7.4",
            "2.589.774",
            "https://www.themoviedb.org/movie/412656-chaos-walking"))
        movie.add(ContentEntity(
            "33331",
            "Mortal Kombat",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            "2021-04-07",
            "https://image.tmdb.org/t/p/w500/8yhtzsbBExY8mUct2GOk4LDDuGH.jpg",
            "7.4",
            "460.465",
            "https://www.themoviedb.org/movie/460465-mortal-kombat"))
        movie.add(ContentEntity(
            "44441",
            "Raya and the Last Dragon",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            "2021-03-03",
            "https://image.tmdb.org/t/p/w500/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
            "8.3",
            "527.774",
            "https://www.themoviedb.org/movie/527774-raya-and-the-last-dragon"))
        movie.add(ContentEntity(
            "55551",
            "Nobody",
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a nobody. When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
            "2021-03-18",
            "https://image.tmdb.org/t/p/w500/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
            "8.5",
            "1.931.287",
            "https://www.themoviedb.org/movie/615457-nobody"))
        movie.add(ContentEntity(
            "66661",
            "The Marksman",
            "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
            "2021-01-15",
            "https://image.tmdb.org/t/p/w500/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
            "7.1",
            "6.914.198",
            "https://www.themoviedb.org/movie/634528-the-marksman"))
        movie.add(ContentEntity(
            "77771",
            "The Unholy",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            "2021-03-31",
            "https://image.tmdb.org/t/p/w500/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
            "5.5",
            "3.333.312",
            "https://www.themoviedb.org/movie/632357-the-unholy"))
        movie.add(ContentEntity(
            "88881",
            "Monster Hunter",
            "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
            "2020-12-03",
            "https://image.tmdb.org/t/p/w500/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
            "7.1",
            "8.221.504",
            "https://www.themoviedb.org/movie/458576-monster-hunter"))
        movie.add(ContentEntity(
            "99991",
            "Tom & Jerry",
            "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
            "2021-02-11",
            "https://image.tmdb.org/t/p/w500/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
            "7.3",
            "8.921.229",
            "https://www.themoviedb.org/movie/587807-tom-jerry"))
        movie.add(ContentEntity(
            "11110",
            "Twist",
            "A Dicken’s classic brought thrillingly up to date in the teeming heartland of modern London, where a group of street smart young hustlers plan the heist of the century for the ultimate payday.",
            "2021-01-22",
            "https://image.tmdb.org/t/p/w500/29dCusd9PwHrbDqzxNG35WcpZpS.jpg",
            "7.1",
            "789.433",
            "https://www.themoviedb.org/movie/644083-twist"))

        return movie
    }

    fun generateDummyTvShow(): List<ContentEntity>{
        val tvShow = ArrayList<ContentEntity>()

        tvShow.add(ContentEntity(
            "11111",
            "I Am Not an Animal",
            "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
            "2004-05-10",
            "https://image.tmdb.org/t/p/w500/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg",
            "9.4",
            "6.944.108",
            "https://www.themoviedb.org/tv/100-i-am-not-an-animal"))
        tvShow.add(ContentEntity(
            "22222",
            "The Rising of the Shield Hero",
            "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
            "2019-01-09",
            "https://image.tmdb.org/t/p/w500/6cXf5EDwVhsRv8GlBzUTVnWuk8Z.jpg",
            "9.1",
            "1.589.774",
            "https://www.themoviedb.org/tv/83095"))
        tvShow.add(ContentEntity(
            "33333",
            "Your Lie in April",
            "Kousei Arima was a genius pianist until his mother's sudden death took away his ability to play. Each day was dull for Kousei. But, then he meets a violinist named Kaori Miyazono who has an eccentric playing style. Can the heartfelt sounds of the girl's violin lead the boy to play the piano again?",
            "2014-10-10",
            "https://image.tmdb.org/t/p/w500/IGbeFv5Ji4W0x530JcSHiQpamY.jpg",
            "9.0",
            "4.211.465",
            "https://www.themoviedb.org/tv/61663"))
        tvShow.add(ContentEntity(
            "44444",
            "Banana Fish",
            "Nature made Ash Lynx beautiful; nurture made him a cold ruthless killer. A runaway brought up as the adopted heir and sex toy of \"Papa\" Dino Golzine, Ash, now at the rebellious age of seventeen, forsakes the kingdom held out by the devil who raised him. But the hideous secret that drove Ash's older brother mad in Vietnam has suddenly fallen into Papa's insatiably ambitious hands—and it's exactly the wrong time for Eiji Okamura, a pure-hearted young photographer from Japan, to make Ash Lynx's acquaintance...",
            "2018-07-06",
            "https://image.tmdb.org/t/p/w500/1UV5di9UIXwrpCW3xQ4RNli5hEV.jpg",
            "9.0",
            "727.774",
            "https://www.themoviedb.org/tv/80564-banana-fish"))
        tvShow.add(ContentEntity(
            "55555",
            "Rent-a-Girlfriend",
            "In today’s Japan, rental services can deliver an afternoon with a friend, a parent, even a fake girlfriend! Kinoshita Kazuya is a 20-year-old failure of a college student. He managed to kiss his girlfriend once, but was dumped after a month. Completely spiteful, Kazuya gets just desperate enough to give it a try. But he quickly discovers how complicated it can be to rent an emotional connection… and his new girlfriend, Mizuhara Chizuru, who’s trying to keep her side hustle secret, will panic when she finds out her real life and Kazuya’s are intertwined in surprising ways! A reckless rom-com filled with love and excitement is about to begin!",
            "2020-07-11",
            "https://image.tmdb.org/t/p/w500/4rqyyM0R3a0EeSlEvdpxDKbjiKB.jpg",
            "9.0",
            "2.914.198",
            "https://www.themoviedb.org/tv/96316"))
        tvShow.add(ContentEntity(
            "66666",
            "ORESUKI: Are you the only one who loves me?",
            "Kisaragi Amatsuyu is invited out alone by the cool beauty upperclassman Cosmos and his childhood friend Himawari. Expecting to hear their confessions, he triumphantly goes to meet each of them in turn. But Cosmos and Himawari both instead confess to Amatsuyu that they like his friend. Amatsuyu fights this lonely battle, but there is another girl who is looking at him. She is a gloomy girl with glasses and braids. Amatsuyu finds that he hates her, because she's always turning her sharp tongue only on him and finding enjoyment in his troubles. But it turns out that she's the only one who actually does like him.",
            "2019-10-03",
            "https://image.tmdb.org/t/p/w500/4MojZik5N62IShd2BFVEHyaRBLP.jpg",
            "9.0",
            "914.198",
            "https://www.themoviedb.org/tv/93019-ore-wo-suki-na-no-wa-omae-dake-ka-yo"))
        tvShow.add(ContentEntity(
            "77777",
            "Scissor Seven",
            "Seeking to recover his memory, a scissor-wielding, hairdressing, bungling quasi-assassin stumbles into a struggle for power among feuding factions.",
            "2018-04-25",
            "https://image.tmdb.org/t/p/w500/A39DWUIrf9WDRHCg7QTR8seWUvi.jpg",
            "9.0",
            "1.224.121",
            "https://www.themoviedb.org/tv/79141"))
        tvShow.add(ContentEntity(
            "88888",
            "Attack on Titan: No Regrets",
            "Many years before becoming the famed captain of the Survey Corps, a young Levi struggles to survive in the capital's garbage dump, the Underground. As the boss of his own criminal operation, Levi attempts to get by with meager earnings while aided by fellow criminals, Isabel Magnolia and Farlan Church. With little hope for the future, Levi accepts a deal from the anti-expedition faction leader Nicholas Lobov, who promises the trio citizenship aboveground if they are able to successfully assassinate Erwin Smith, a squad leader of the Survey Corps. As Levi and Erwin cross paths, Erwin acknowledges Levi's agility and skill and gives him the option to either become part of the expedition team, or be turned over to the Military Police, to atone for his crimes. Now closer to the man they are tasked to kill, the group plans to complete their mission and save themselves from a grim demise in the dim recesses of their past home. However, they are about to learn that the surface world is not as liberating as they had thought and that sometimes, freedom can come at a heavy price. Based on the popular spin-off manga of the same name, Attack on Titan: No Regrets illustrates the encounter between two of Attack on Titan's pivotal characters, as well as the events of the 23rd expedition beyond the walls.",
            "2021-03-24",
            "https://image.tmdb.org/t/p/w500/xGdz67d5WHIU7kIqVHO2TxIpmhZ.jpg",
            "8.9",
            "4.111.398",
            "https://www.themoviedb.org/tv/73055-shingeki-no-kyojin-kuinaki-sentaku"))
        tvShow.add(ContentEntity(
            "99999",
            "Redo of Healer",
            "In a world of monsters, adventurers and magic, some of the most gifted healers are subjugated to brute force. Keyaru gains the ability to rewind time and turns the tables on those who’ve exploited him in this dark fantasy tale of vengeance and fury.",
            "2021-01-13",
            "https://image.tmdb.org/t/p/w500/hynFI7MltF1BBvroh3iJplnBZyc.jpg",
            "8.9",
            "7.212.138",
            "https://www.themoviedb.org/tv/99071"))
        tvShow.add(ContentEntity(
            "10101",
            "Made In Abyss",
            "Located in the center of a remote island, the Abyss is the last unexplored region, a huge and treacherous fathomless hole inhabited by strange creatures where only the bravest adventurers descend in search of ancient relics. In the upper levels of the Abyss, Riko, a girl who dreams of becoming an explorer, stumbles upon a mysterious little boy.",
            "2017-07-07",
            "https://image.tmdb.org/t/p/w500/5ICCEOKdqHFGp03zNMZmi95q9WB.jpg",
            "8.9",
            "914.198",
            "https://www.themoviedb.org/tv/72636-made-in-abyss"))

        return tvShow
    }
}