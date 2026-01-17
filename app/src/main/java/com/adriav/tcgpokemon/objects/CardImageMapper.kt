package com.adriav.tcgpokemon.objects

object CardImageMapper {
    fun map(cardID: String): String =
        when (cardID) {
            "bog-1" -> "https://static.tcgcollector.com/content/images/42/52/bb/4252bb391e476c38e92a46b8f6d84ab97bb505216d428c73ddae6fd5c4f0d9a4.jpg"
            "bog-2" -> "https://static.tcgcollector.com/content/images/f0/1c/bc/f01cbc58b4a577d8598240a787d18cee89c2ac4c39d13f839c1c9d106eb55fc1.jpg"
            "bog-3" -> "https://static.tcgcollector.com/content/images/7e/22/9e/7e229e01b34d0c6766a01e64f5fc8ccf5ce20c456ee6c7499a986590428a51f7.jpg"
            "bog-4" -> "https://static.tcgcollector.com/content/images/f8/94/5b/f8945bcd3348ae33f9b1371f3b07960e57e5f9964f218c18ff662eb5ba3f2092.jpg"
            "bog-5" -> "https://static.tcgcollector.com/content/images/97/bb/68/97bb685000321b3ba7c7b4e0fce8506f88facc2478f3070e9ff8d3781f9b679b.jpg"
            "bog-6" -> "https://static.tcgcollector.com/content/images/92/b2/62/92b2623bd3e291605daff5b264eb316c8a11c2fcb2e4e15424bfbad3e0b9cdfc.jpg"
            "bog-7" -> "https://static.tcgcollector.com/content/images/67/b8/be/67b8be072b793081f8503362c5b06970bd0bc37ac148fba8cb9cbc974a6f3cd2.jpg"
            "bog-8" -> "https://static.tcgcollector.com/content/images/1d/a2/76/1da2766c19656cb9381516cbcd96d3a5bcaba6d59161d4d812346bfc1fd83cd5.jpg"
            "bog-9" -> "https://static.tcgcollector.com/content/images/08/14/1c/08141ccae776ab7cb5a6052d99ad665649041c3a4cdda1b4356aafbc732affec.jpg"

            else -> "null"
        }
}