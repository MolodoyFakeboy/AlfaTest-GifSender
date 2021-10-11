# AlfaTest-GifSender

# Description
Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:
если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich
если ниже - отсюда https://giphy.com/search/broke
Ссылки
REST API курсов валют - https://docs.openexchangerates.org/
REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide

# Launch instructions
1.Dowload my app from git

2.Build docker container: docker build -t alfa-test .

3.Run docker container: docker run -p 8100:8100 alfa-test

# Endpoints
http://localhost:8100/api/gif?base=afd
Should return the gif depending on the exchange rate
