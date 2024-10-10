Clase "Hora"

Esta clase tiene la función de simular una hora, por tanto, contiene los atributos de h (hora), m (minutos) y s (segundos).
El método más importante encontrado en la definición de esta clase es isLater, el cual recibe dos parámetros de la clase Hora (hora1 y hora2), y retorna un booleano que indica
si la hora1 está después de la hora2. Implementé este método comparando en orden los componentes de las horas; pero se me acaba de ocurrir que simplemente se podía determinar esto
convirtiendo las horas y minutos a segundos, sumándolas con los segundos, y así solo comparar dos cantidades.


Clase "Nodo"

Esta clase se creó para simular un nodo de una lista simplemente enlazada, por tanto, sus atributos son: la referencia al siguiente nodo en la lista enlazada de la que forma parte
y su data, que en este caso es un "PrintJob".


Clase "PrintJob"

Esta clase se creó para simular los trabajos de impresión que se envían a la cola de impresión, por tanto, sus atributos son los pedidos por la consigna: nombre de usuario, hora y
prioridad.
Contiene el método setPrio para cambiar la prioridad en caso de que el usuario así lo desee.


Clase "PrintManager"

Esta clase actúa como el "Main" del proyecto. Trabaja como una sencilla simulación de la entrada de los datos.
Utiliza un bucle que se mantrendrá activo mientras la variable booleana "active" sea true. En este bucle se le pide al usuario qué desea hacer; las opciones son: enviar un trabajo
de impresión, hacer que se procese el próximo trabajo en la lista, y salir (hacer false la variable active).
En el caso de que se quiera enviar un trabajo de impresión, se le pide al usuario su nombre de usuario, la hora en la que se supone que está enviando el trabajo y también se le pide
si desea cambiar la prioridad de su trabajo (a Baja o Alta).
En el caso de que se quiera observar el próximo trabajo a procesar, se le pide a la clase PrintService que procese el próximo trabajo y se le hace saber al usuario la información
sobre dicho trabajo procesado.


Clase "PrintQueue"

Esta clase es la implementación de la cola utilizada para gestionar el procesamiento de los trabajos de impresión.
Debido a la forma en que se lleva a cabo la simulación, pudiéndose alterar el lugar donde debería ir cada trabajo (no es simplemente el primero que llegue es el primero en salir, sino
que dependiendo de los atributos del trabajo de impresión, este se podría colocar en cualquier lugar de la cola), esta clase solo tiene la referencia de la cabeza de la cola (el
siguiente trabajo de los contenidos en ella que se debería procesar a continuación), pues, al final, la utilidad de tener una referencia al último elemento de la cola se pierde cuando
se da este caso no convencional de prioridades, siendo que empezando a recorrer la lista desde cualquier extremo para insertar el trabajo correctamente, la complejidad de tiempo
pueda ir desde O(1) hasta O(N); pero, por temas de que la cabeza es más útil en este caso (pues siempre indicará en tiempo O(1) cuál es el siguiente elemento a procesar), se prefirió
la referencia de este extremo.
Los métodos de esta clase son los clásicos de las colas (enqueue para insertar y dequeue para sacar elementos), aunque la implementación de enqueue no es del todo clásica (por el tema
del sistema de prioridades). Dequeue simplemente retorna el trabajo de impresión en la cabeza, el cuál siempre será el más alto en prioridad, y se elimina de la lista. En Enqueue,
primero se comprueba si la cabeza de la cola es null, en cuyo caso simplemente el nuevo nodo se convierte en la cabeza; luego extrae los atributos importantes para determinar la
prioridad del trabajo de impresión recibido: la prioridad y la hora. Lueog, la lista se empieza a recorrer desde la cabeza y se determina el lugar del nuevo nodo según comparaciones
de su data (la nueva data) con la de los nodos que ya estaban, primero se compara la prioridad, siguiendo buscando su lugar en caso de que posea menos prioridad, insertándose si ya llegó
a un punto en que su prioridad es mayor a los siguientes, y, en caso de que su prioridad se igual, se comparan las horas con el método isLater de la clase Hora. En caso de que no haya
sido apto para insertarse con anterioridad, entonces pasa a ser el último elemento (ahora me doy cuenta de que hay un error, porque al final, dadas las condiciones del bucle, n debería
de ser null, lanzando un NullPointerException al tratar de insertar al final [aquí entonces si hubiese sido útil tener la referencia del útlimo elemento]).
También se incluyó el método valuePrio, que recibe un caracter representativo de una prioridad y lo convierte a un valor numérico según su lugar en la jerarquía. Esto para facilitar la
comparación de las prioridades (hubiese sido más elegante con enums pero no sé si se pueden implementar enums con valores como en lenguaje C).


Clase "PrintService"

Esta es la clase controladora del proyecto. Se implementó con ella el patrón Singleton, por lo que tiene una configuración clásica de métodos y atributos para clases controladoras en el
patrón Singleton.
Esta clase posee la cola de impresión. También posee los métodos para procesar el próximo trabajo de impresión (hacer dequeue) y enviar trabjos de impresión (hacer enqueue):
processNextJob y sendJob, respectivamente.
