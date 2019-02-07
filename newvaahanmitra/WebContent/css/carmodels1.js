  /*
	*	Original script by: Shafiul Azam
	*	Version 4.0
	*	Modified by: Luigi Balzano

	*	Description:
	*	Inserts Countries and/or States as Dropdown List
	*	How to Use:

		In Head section:
		----------------
		<script type= "text/javascript" src = "countries.js"></script>
		
		In Body Section:
		----------------
		Select Country (with states):   <select id="country" name ="country"></select>
			
		Select State: <select name ="state" id ="state"></select>

        Select Country (without states):   <select id="country2" name ="country2"></select>
			
		<script language="javascript">
			populateCountries("country", "state");
			populateCountries("country2");
		</script>

	*
	*	License: Free to copy, distribute, modify, whatever you want to.
	*	Aurthor's Website: http://bdhacker.wordpress.com
	*
*/

// Brands
var brand_arr = new Array("AUDI", "BMW", "HONDA", "TATA", "TOYOTA", "VOLKSWAGEN");

// Models
var m_a = new Array();
m_a[0]="";
m_a[1]="A3 Sedan|S5 Sportback|A8 L|A6 Sedan|Q3|RS6 Avant";
m_a[2]="X1|Z4|M3|i3|X6";
m_a[3]="Civic|BRV|City|Brio";
m_a[4]="Safari|Nano|Aria|Nexon|Hexa";
m_a[5]="Innova Crysta|Fortuner|Etios Cross|Vios";
m_a[6]="AMEO|POLO|GTI|BEETLE";


function populateModels( brandElementId, modelElementId ){
	
	var selectedBrandIndex = document.getElementById( brandElementId ).selectedIndex;

	var modelElement = document.getElementById( modelElementId );
	
	modelElement.length=0;	// Fixed by Julian Woods
	modelElement.options[0] = new Option('Select Models','');
	modelElement.selectedIndex = 0;
	
	var model_arr = m_a[selectedBrandIndex].split("|");
	
	for (var i=0; i<model_arr.length; i++) {
		modelElement.options[modelElement.length] = new Option(model_arr[i],model_arr[i]);
	}
}

function populateBrands(brandElementId, modelElementId){
	// given the id of the <select> tag as function argument, it inserts <option> tags
	var brandElement = document.getElementById(brandElementId);
	brandElement.length=0;
	brandElement.options[0] = new Option('Select Brand','-1');
	brandElement.selectedIndex = 0;
	for (var i=0; i<brand_arr.length; i++) {
		brandElement.options[brandElement.length] = new Option(brand_arr[i],brand_arr[i]);
	}

	// Assigned all countries. Now assign event listener for the states.

	if( modelElementId ){
		brandElement.onchange = function(){
			populateModels( brandElementId, modelElementId );
		};
	}
}