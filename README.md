# Ticket

Consumo da API:
https://run.mocky.io/v3/ca30b574-72b5-40ed-b83c-63e547378ebe

Bibliotecas utilizadas:
Retrofit
Gson

Package:
Androidx

Architetura:
MVVM

Projeto composta de uma lib (Ticket), com uma função pública com uma class singleton, solicitando a chamada a uma API solicitando um "Ticket" utilizando
a biblioteca Retrofit, usando como parse a biblioteca Gson, tal função solicita duas funções lambda para capturar o retorno de sucesso e erro da chamada
da API. Tendo como opcional pela API uma conjunto de informações sobre o device.

Versões miníma do app/lib:
minSdk 21
targetSdk 33
