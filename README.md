gimei-java [![Build Status](https://travis-ci.org/moznion/gimei-java.svg)](https://travis-ci.org/moznion/gimei-java)
==========

[gimei](https://github.com/willnet/gimei)のJava移植版です．
漢字，ひらがな，カタカナの3種類の情報を持った架空の情報を生成します．

Synopsis
---

### Name

男女を区別せずに架空の人名を生成します．

```java
Name name = Gimei.generateName();

name.kanji();    // => "丹羽 大志"
name.hiragana(); // => "にわ たいし"
name.katakana(); // => "ニワ タイシ"

NameUnit last = name.last();
last.kanji();    // => "丹羽"
last.hiragana(); // => "にわ"
last.katakana(); // => "ニワ"

NameUnit first = name.first();
first.kanji();    // => "大志"
first.hiragana(); // => "たいし"
first.katakana(); // => "タイシ"

name.isMale();   // => true or false
name.isFemale(); // => true or false
```

### Male

架空の男性の人名を生成します．

```java
Male male = Gimei.generateMale();

male.kanji();    // => "丹羽 大志"
male.hiragana(); // => "にわ たいし"
male.katakana(); // => "ニワ タイシ"

NameUnit last = male.last();
last.kanji();    // => "丹羽"
last.hiragana(); // => "にわ"
last.katakana(); // => "ニワ"

NameUnit first = male.first();
first.kanji();    // => "大志"
first.hiragana(); // => "たいし"
first.katakana(); // => "タイシ"

male.isMale();   // => true
male.isFemale(); // => false
```

### Female

架空の女性の人名を生成します．

```java
Female female = Gimei.generateFemale();

female.kanji();    // => "手塚 陽子"
female.hiragana(); // => "てづか ようこ"
female.katakana(); // => "テヅカ ヨウコ"

NameUnit last = female.last();
last.kanji();    // => => "手塚"
last.hiragana(); // => => "てづか"
last.katakana(); // => => "テヅカ"

NameUnit first = female.first();
first.kanji();    // => "陽子"
first.hiragana(); // => "ようこ"
first.katakana(); // => "ヨウコ"

female.isMale();   // => false
female.isFemale(); // => true
```

### Taro

<ランダムな名詞> + "太郎"を生成します．

```java
Taro taro = Gimei.generateTaro();

taro.kanji();    // => "パソコン 太郎"
taro.hiragana(); // => "ぱそこん たろう"
taro.katakana(); // => "パソコン タロウ"

NameUnit last = taro.last();
last.kanji();    // => "パソコン"
last.hiragana(); // => "ぱそこん"
last.katakana(); // => "パソコン"

NameUnit first = taro.first();
first.kanji();    // => "太郎"
first.hiragana(); // => "たろう"
first.katakana(); // => "タロウ"

taro.isMale();   // => true
taro.isFemale(); // => false
```

### Hanako

<ランダムな名詞> + "花子"を生成します．

```java
Hanako hanako = Gimei.generateHanako();

hanako.kanji();    // => "パソコン 花子"
hanako.hiragana(); // => "ぱそこん はなこ"
hanako.katakana(); // => "パソコン ハナコ"

NameUnit last = hanako.last();
last.kanji();    // => "パソコン"
last.hiragana(); // => "ぱそこん"
last.katakana(); // => "パソコン"

NameUnit first = hanako.first();
first.kanji();    // => "花子"
first.hiragana(); // => "はなこ"
first.katakana(); // => "ハナコ"

hanako.isMale();   // => false
hanako.isFemale(); // => true
```

### Address

架空の住所を生成します．

```java
Address address = Gimei.generateAddress();

address.kanji();    // => "熊本県須崎市国府町新通り"
address.hiragana(); // => "くまもとけんすさきしこくふちょうしんどおり"
address.katakana(); // => "クマモトケンスサキシコクフチョウシンドオリ"

NameUnit prefecture = address.prefecture();
prefecture.kanji();    // => "熊本県"
prefecture.hiragana(); // => "くまもとけん"
prefecture.katakana(); // => "クマモトケン"

NameUnit city = address.city();
city.kanji();    // => "須崎市"
city.hiragana(); // => "すさきし"
city.katakana(); // => "スサキシ"

NameUnit town = address.town();
town.kanji();    // => "国府町新通り"
town.hiragana(); // => "こくふちょうしんどおり"
town.katakana(); // => "コクフチョウシンドオリ"
```

### Noun

ランダムで名詞を返します．

```java
Noun noun = Gimei.generateNoun();

noun.kanji();    // => "太陽エンジニヤ"
noun.hiragana(); // => "たいようえんじにや"
noun.katakana(); // => "タイヨウエンジニヤ"
```

Requires
--

- JDK 7 or later

See also
--

[gimei](https://github.com/willnet/gimei)

Author
--

moznion (<moznion@gmail.com>)

名詞データについて
--

名詞データ (nouns.yml) の内容は修正BSDライセンスで配布されている [NAIST Japanese Dictionary](http://osdn.jp/projects/naist-jdic/)
の `mecab-naist-jdic-0.6.3b-20111013.tar.gz` がオリジナルデータです．

License
--

```
The MIT License (MIT)
Copyright © 2015 moznion, http://moznion.net/ <moznion@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the “Software”), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```

