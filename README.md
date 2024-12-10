# Розробка програмного забезпечення на платформі Java

## Лабораторна робота №5

### Інструкція зі встановлення та першого запуску

_Застосунок було написано в Intellij IDEA, тому тут буде надана інструкція з інсталювання додатка саме через цю IDE._

1. **Клонувати цей репозиторій на свою локальну машину.**

<img src="img/img1.png" alt="Фото 1">

У початковому вікні Intellij IDEA треба натиснути кнопку `Get from VCS`.

<img src="img/img2.png" alt="Фото 2">

У наступному вікні потрібно вказати посилання на цей репозиторій та шлях до директорії, у якій цей репозиторій буде клоновано.

2. **Запустити додаток.**

<img src="img/img3.png" alt="Фото 3">

Треба відкрити файл `Main.java`.

<img src="img/img4.png" alt="Фото 4">

Тоді стануть доступними кнопки для запуску додатка.

<img src="img/img5.png" alt="Фото 5">

При натисканні кнопки запуску зліва від коду в діалоговому вікні потрібно вибрати перший пункт.

### Інформація щодо роботи додатка

<img src="img/img6.png" alt="Фото 6">

На початку своєї роботи програма створює квартиру, в якій міститься певна кількість електроприладів (їх кількість, тип та характеристики визначаються рандомно, у деяких діапазонах).

<img src="img/img7.png" alt="Фото 7">

Далі, деякі з цих приладів вмикаються в розетку, з деякою ймовірністю частина підключених приладів будуть вимкнуті. Після цих дій, для приладів, що ще підключені до живлення, буде підрахована загальна споживана потужність.

<img src="img/img8.png" alt="Фото 8">

Наступним кроком, програма відсортовує всі електроприлади в квартирі на основі потужності.

<img src="img/img9.png" alt="Фото 9">

Наостанок, програма пропонує користувачу ввести межі діапазону електромагнітного випромінювання, за яким будуть шукатись прилади в квартирі. Як бачимо, програма може певним чином валідувати дані, що ввів користувач, виводячи помилку, якщо були введені якісь символи, окрім цифр, від'ємні числа, а також діапазон, у якому верхня межа менша за нижню. Якщо діапазон введено правильно, то програма повертає очікуваний результат.