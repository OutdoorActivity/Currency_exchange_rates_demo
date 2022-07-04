# Краткое руководство

Cервис, который обращается к сервису курсов валют, и отображает gif:
если курс по отношению к USD за сегодня стал выше вчерашнего, то в ответ клиенту отправляется рандомная отсюда https://giphy.com/search/rich,
если ниже - отсюда https://giphy.com/search/broke

1) https://docs.openexchangerates.org/ - здесь берутся данные по валюте

2) https://developers.giphy.com/docs/api#quick-start-guide - отсюда берётся gif

http://localhost:8080/v1 - GET запрос получения стартовой страницы с формой ввода данных: 

| Дата(гггг-мм-дд)                               | App_Id                                                     | Валюта                          |
| -------------                                  | --------------                                             | --------                        |
| дата, с которой будет сравниваться текущий день| app_id(с сервиса https://openexchangerates.org/signup/free)| код валюты(RUB, EUR, BTC и т.д.)|

Высчитывается разница значений введённой валюты по отношению к USD между текущей датой и введённой клиентом. 
После нажатия кнопки "подтвердить данные", клиент вызывает метод с маппингом v1/difference и получает конечный результат.

Другие методы можно посмотреть по пути: src/main/java/com/example/demo/controller/ApiController.java

GET: v1/latest/currencies

GET: v1/latest/info

GET: v1/latest/{symbols}

GET: v1/historical/{date}

GET: v1/historical/info/{date}

GET: v1/gifs/rich

GET: v1/gifs/broke

GET: v1/difference
