# Currency_exchange_rates_demo

Cервис, который обращается к сервису курсов валют, и отображает gif:
если курс по отношению к USD за сегодня стал выше вчерашнего, то в ответ клиенту отправляется рандомная отсюда https://giphy.com/search/rich,
если ниже - отсюда https://giphy.com/search/broke

1)https://docs.openexchangerates.org/ - здесь берутся данные по валюте

2)https://developers.giphy.com/docs/api#quick-start-guide - отсюда берётся gif

GET: http://localhost:8080/v1 - адрес получения стартовой страницы с формой ввода данных(дата с которой будет сравниваться текущий день,
app_id(с сервиса https://openexchangerates.org/signup/free), код валюты(RUB, EUR, BTC и т.д.)).

Высчитывается разница значений введённой валюты по отношению к USD между текущей датой и введённой пользователем. 
После нажатия кнопки "подтвердить данные" клиент получает конечный результат. 


