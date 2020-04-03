class Main {
    // contains information about [Product, Group, Cost]
def products = [
    ["A", "G1", 20.1],
    ["B", "G2", 98.4],
    ["C", "G1", 49.7],
    ["D", "G3", 35.8],
    ["E", "G3", 105.5],
    ["F", "G1", 55.2],
    ["G", "G1", 12.7],
    ["H", "G3", 88.6],
    ["I", "G1", 5.2],
    ["J", "G2", 72.4]]
 
// contains information about Category classification based on product Cost
// [Category, Cost range from (inclusive), Cost range to (exclusive)]
// i.e. if a Product has Cost between 0 and 25, it belongs to category C1
// ranges are mutually exclusive and the last range has a null as upper limit.
def category = [
    ["C3", 50, 75],
    ["C4", 75, 100],
    ["C2", 25, 50],
    ["C5", 100, null],
    ["C1", 0, 25]]
 
// contains information about margins for each product Category
// [Category, Margin (either percentage or absolute value)]
def margins = [
    "C1" : "20%",
    "C2" : "30%",
    "C3" : "0.4",
    "C4" : "50%",
    "C5" : "0.6"]
    
    
  // YOUR CODE GOES BELOW THIS LINE
  // EDIT OR ADD COODE AS NEEDED, MAKE SURE YOU PRINT TO SCREEN THE AVERAGE FOR THE INPUT GROUP
 
    static void main(String[] args) {
       for (inputline in System.in.readLines()) {
            println(getGroupAverage(inputline));
       }
    }
    
    public static getGroupAverage(String group)
    {    
        Main main = new Main()
        def suma = 0
        int contador = 0
        main.products.each{
            if(it[1] == group){
                main.category.eachWithIndex{linea , index ->
                    if(linea[1] < it[2] && linea[2] > it[2] || linea[1] < it[2] && linea[2] == null){
                        suma = suma + (it[2] * (1 + main.getPorcentaje(main.margins,linea[0])))
                        contador = contador + 1
                    }
                }
            }
        }
        def promedio = Math.round((suma / contador) * 10)/10
        return(promedio)
    }

    def getPorcentaje(margins,valor) {
        
        def porcentaje = margins.get(valor)
        
        if (!porcentaje.endsWith('%')) {
            return porcentaje.toDouble()
        } else {
            def division = porcentaje.split('%')
            def punto = (division[0].toFloat())/100
            return punto
        }
    }
}