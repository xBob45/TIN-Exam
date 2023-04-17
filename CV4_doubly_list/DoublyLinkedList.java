package doubly_list;

public class DoublyLinkedList {
	
	Node head = null; //Začátek seznamu
	Node tail = null; //Konec seznamu
	
	
	public void addFirst(int data) {
		Node newNode = new Node(data); //Zavoláním metody se vytvoří nový objekt třídy "Node" a incializuje se class variable "data"
		
		
		if (head == null) { //Jestliže je list prázdný
			head = tail = newNode; //potom "newNode" bude začátkem i koncem listu
			head.setPrevious(null);; //"previous" bude směřovat na "null" jelikož v tomoto případě ještě žádný "předchozí" neexistuje
			tail.setNext(null); //Žádný další nebude, jelikož vkládáme metodou "addFirst" --> toto bude poslední element v listu
		}
		
		else {
			head.setPrevious(newNode); //Současný začátek seznamu bude ukazovat na newNode jako na element, který je před ním, tento element se poté stane začátkem
			newNode.setPrevious(null); //Jelikož "newNode" bude začátek tak před ním už nic nebude
			newNode.setNext(head); //Nasledující hodnota potom co se nový objekt "newNode" stane začátkem bude současný začátek
			head = newNode; //"newNode" je v konečném kroku prohlášeno za začátek seznamu
		}
	}
	
	public void addLast(int data) {
		Node newNode = new Node(data); //Vytvoříme nový objekt typu Node s daty "data"
		
		if (tail == null) { //Pokud seznam je prázdný
			head = tail = newNode; //Nastavíme začátek i konec seznamu na nový uzel
			head.setPrevious(null); //Před začátkem seznamu nebude žádný prvek
			tail.setNext(null); //Za koncem seznamu nebude žádný prvek
		} else {
			tail.setNext(newNode); //Nastavíme "next" současného konce seznamu na nový uzel
			newNode.setPrevious(tail); //Nastavíme "previous" nového uzlu na současný konec seznamu
			tail = newNode; //Nastavíme nový uzel jako nový konec seznamu
			tail.setNext(null); //Za novým koncem seznamu nebude žádný prvek
		}
	}
	
	
	public void removeFirst() {
		
		if (head == null) { //Kontrola jestli v listu vůbec něco je, v případě, že ne tak . . . 
			System.out.println("Nothink to delete, list is empty");
		}
		else {
			head = head.getNext();/*V případě, že list není prázdný tak se ukazatel přesune ze současného začátku listu na následující prvek, čímž dojde k tomu, že
		 					 proměnná "head" se bude rovnat "null" a vezme si ji GarbageCollector*/ 	
		}
	}
	
	public void removeLast() {
		if (tail == null) { //Pokud je seznam prázdný
			System.out.println("Nothing to delete, list is empty");
		} else if (head == tail) { //Pokud seznam obsahuje pouze jeden prvek
			head = tail = null; //Nastavíme začátek i konec seznamu na null
		} else {
			tail = tail.getPrevious(); //Posuneme ukazatel konečného prvku na předchozí prvek
			tail.setNext(null); //Nastavíme "next" u posledního prvku na null, aby se uvolnila paměť pro GC
		}
	}

	
	public boolean contains(int data) {
		Node current_node = head; /*Tohle si lze představit něco jako "posuvník", který budu posouvat jak budu procházet seznam. důležité je aby ze začátku
								  nastaven na začátek listu*/
		
		while(current_node != null) {
			if(current_node.getData() == data) {
				return true;
			}
			else {
				current_node = current_node.getNext(); /*V případě, že se obsah proměnné data u současného objektu neshoduje s hodnotou, kterou hledáme, 
												  posuneme se na další*/
			}
		}
		return false;
		
		
	}
	
	public void printList() {
		Node current_node = head;
		
		if(head == null) {
			System.out.println("List is empty");
		}
		else {
			System.out.print("List: ");
			while(current_node != null) {
				System.out.print(current_node.getData() + " ");
				current_node = current_node.getNext();
			}
		}
		System.out.println();
	}
	public void printList_Reverse() {
		Node current_node = tail;
		
		if(tail == null) {
			System.out.println("List is empty");
		}
		else {
			System.out.print("List(Reverse): ");
			while(current_node != null) {
				System.out.print(current_node.getData() + " ");
				current_node = current_node.getPrevious();
			}
		}
		System.out.println();
	}
	
	
	

	
	

}
