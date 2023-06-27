package com.example.a22byte.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Book
import com.example.data.BookDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class DataViewModel(private val bookDao: BookDao): ViewModel() {
    val harry_potter = Book(
        "Harry Potter",
        "Мистер и миссис Дурсль проживали в доме номер четыре по Тисовой улице " +
                "и всегда с гордостью заявляли, что они, слава богу, абсолютно нормальные люди. ",
        "https://img4.labirint.ru/rc/dc5ac469aa386ba6ff0767521b09ac7f/363x561q80/books43/424618/cover.jpg?1670073957"
    )

    val flowers_for_algernon = Book(
        "Flowers for Algernon",
        "Док Штраус сказал што я должен писать все што я " +
                "думаю и помню и все што случаеца со мной с севодня.",
        "https://libreed.ru/wp-content/uploads/2017/02/Tsvety_dlya_Eldzhernona.jpg"
    )

    val _1Q84 = Book(
        "1Q84",
        "Радио в такси играло «Симфониетту» Яначека. Внутри машины, застрявшей в пробке, такое даже музыкой не назовешь. " +
                "Да и водитель мало похож на человека, который все это внимательно слушает.",
        "https://knizhnik.org/covers/page-4031-murakami-1q84-1.jpg"
    )

    val crime_and_punishment = Book(
        "Crime and punishment",
        "В начале июля, в чрезвычайно жаркое время, под вечер, один молодой человек вышел из своей каморки, которую нанимал от жильцов " +
                "в С — м переулке, на улицу и медленно, как бы в нерешимости, отправился к К — ну мосту.",
        "https://avidreaders.ru/pics/8/1/1981.jpg"
    )

    val consumer_society = Book(
        "Consumer society",
        "Большинство французов должны были дождаться мая 1968 г.," +
                "чтобы узнать, что они живут в «обществе потребления». ",
        "https://upload.wikimedia.org/wikipedia/ru/thumb/f/f3/%D0%9E%D0%B1%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%BE_%D0%BF%D0%BE%D1%82%D1%80%D0%B5%D0%B1%D0%BB%D0%B5%D0%BD%D0%B8%D1%8F-_%D0%B5%D0%B3%D0%BE_%D0%BC%D0%B8%D1%84%D1%8B_%D0%B8_%D1%81%D1%82%D1%80%D1%83%D0%BA%D1%82%D1%83%D1%80%D1%8B.jpeg/238px-%D0%9E%D0%B1%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%BE_%D0%BF%D0%BE%D1%82%D1%80%D0%B5%D0%B1%D0%BB%D0%B5%D0%BD%D0%B8%D1%8F-_%D0%B5%D0%B3%D0%BE_%D0%BC%D0%B8%D1%84%D1%8B_%D0%B8_%D1%81%D1%82%D1%80%D1%83%D0%BA%D1%82%D1%83%D1%80%D1%8B.jpeg"
    )

    val pride_and_prejudice = Book(
        "Pride and Prejudice",
        "В целом мире не сыскать безумца, который решился бы оспорить тот факт," +
                " что богатый холостяк непременно должен находиться в постоянном поиске спутницы жизни.",
        "https://cv9.litres.ru/pub/c/cover_415/6257491.webp"
    )

    val gone_with_the_wind = Book(
        "Gone with the Wind",
        "Скарлетт О’Хара не была красавицей, но мужчины вряд ли отдавали себе в этом отчет, " +
                "если они, подобно близнецам Тарлтонам, становились жертвами ее чар.",
        "https://img4.labirint.ru/rc/314e92f677b7055c9809f6ab1a067f38/363x561q80/books18/174500/cover.jpg?1280394613"
    )

    val jane_eyre = Book(
        "Jane Eyre",
        "В этот день нечего было и думать о прогулке. Правда, утром мы еще побродили часок по дорожкам облетевшего сада, но после обеда...",
        "https://knizhnik.org/covers/page-40073-dzhejn-ejr.jpg"
    )

    val little_women = Book(
        "Little Women",
        "– Ну что это за Рождество без подарков! – проворчала лежащая на ковре Джо.",
        "https://cv8.litres.ru/pub/c/cover_200/49983685.jpg"
    )

    val the_great_gatsby = Book(
        "The Great Gatsby",
        "В юности, когда мое сердце было открыто, мир казался бесконечным, а жажда познания не утолена, " +
                "я услышал от отца фразу, которую я навсегда сохранил в памяти...",
        "https://cdn.eksmo.ru/v2/ITD000000001306857/COVER/cover1__w820.jpg"
    )

    fun addBooks(){
        viewModelScope.launch(Dispatchers.IO) {
//            if (bookDao.isEmpty()){
                bookDao.insert(harry_potter)
                bookDao.insert(flowers_for_algernon)
                bookDao.insert(_1Q84)
                bookDao.insert(crime_and_punishment)
                bookDao.insert(consumer_society)
                bookDao.insert(pride_and_prejudice)
                bookDao.insert(gone_with_the_wind)
                bookDao.insert(jane_eyre)
                bookDao.insert(little_women)
                bookDao.insert(the_great_gatsby)
//            }
        }
    }

}