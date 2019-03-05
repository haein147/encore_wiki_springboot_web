# encore_wiki_springboot_web
최적화된 스코어링 + Doc2Vec이 적용된 검색엔진 웹서비스

<br>
<br>

## 클래스 설명
1. Spring Boot 로 웹서비스 구현
2. wikipedia API, elasticsearch rest client로 데이터를 받아옴
3. script score 적용을 위해 com.encore.wikidemo.client.ElasticSearchClient 를 고도화
4. 아래의 공식을 구현(가중치 조절)
<img src="https://user-images.githubusercontent.com/43582223/53785199-09c52680-3f5b-11e9-90da-dae509285788.png"> </img>

5. Doc2Vec을 위해 kowiki-20190101-pages-articles.xml.bz2 을 받아서 gensim의 wikiCorpus로 변환 후 학습
6. Doc2Vec에 적용시키기 위해 전체문서에서 <from title, to title1, to title2..> list 형식으로 변환해준다.
7. 위의 문서를 학습시킨 model로 Doc2Vec 적용
8. 적용 후 light sail 에 생성한 데이터베이스 인스턴스에 서빙함
9. Spring Boot로 mysql 연동해서 검색된 쿼리와 가장 가까운 벡터화된 문서 top3를 추천해준다.
<br>
<br>

## 고도화 작업(앞으로 진행해야 할 것)
1. Doc2Vec이 학습되는 문서들은 특수문자가 붙으면 학습이 불가한 경우
 -> 44만개 문서 중 11만개 정도만 완료가 되었음
2. Apache Spark 로 Doc2Vec을 새롭게 적용해 볼 예정
<br>
<br>


