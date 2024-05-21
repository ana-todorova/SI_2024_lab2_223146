Втора лабораториска вежба по Софтверско инженерство

Ана Тодорова, бр. на индекс 223146

2. Control Flow Graph
   
   ![CFG](CFG.png)
   
3. Цикломатска комплексност
   
 -Ја користиме формулата со предикатни јазли(јазли на разгранување)=>P+1, од кај што се добива P=9, затоа комплексноста е 10. 
4. Тест случаи според критериумот Every branch

  -Потребни ми беа 7 тест случаеви 
	1. allItems е null, затоа фрламе исклучок и програмата завршува
	2. allItems e празна листа, payment e 0
	3. allItems e празна листа, payment e -1
	4. allItems = [" ", null, 10, 0.1f], payment = 1, barcode e null, името е празен string
	5. allItems = [" ", "0222", 301, 0.2f], payment = 2, barcode има 0 на почеток, цената е над 300
	6. allItems = ["ime1", "33bukvi33", 30, 0.3f], payment = 3, barcode има букви во него, name не е празен string
	7. allItems = ["ime2", "4444", 40, 0.4f], payment = -4, price е помала од 300, payment e негативен	

5. Тест случаи според критериумот Multiple Condition

  -4 тест случаеви според условот if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
	 1. assertEquals(true, SILab2.checkCart(create(new Item("ime1", "0111", 1111, 0.1f)), 100)); => TTT, доделените вредности се валидни
	 2. assertEquals(false, SILab2.checkCart(create(new Item("ime2", "2222", 2222, 0.1f)), 2)); => TTF, само за barcode е неточна
	 3. assertEquals(false, SILab2.checkCart(create(new Item("ime3", "0323", 3333, 0)), 3)); => TFX, price=true, discount=false, barcode=не е важна
	 4. assertEquals(false, SILab2.checkCart(create(new Item("ime4", "0333", 111, 0.3f)), 4)); => FXX, price=false, discount, barcode=не се важни

6. Објаснување на напишаните unit tests
   
  -Unit тестовите се пишуваат во посебна класа SILab2Test, каде што се опфаќаат сите случаеви според Every branch и Multiple Condition методите.
