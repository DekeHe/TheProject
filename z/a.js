const drop_create_insert=(o)=>
{
	let rr=''
	for(let v in o)
	{
		const si=o[v]

		const s=si[0]
		//instances
		const i=si.slice(1)

		//schema
		let ss='';s.forEach(v=>ss+='\t'+v+' '+'varchar(50), '+'\n');ss=ss.slice(0,ss.length-3)

		//drop create and schema
		rr+= 'drop table if exists '+v+';\n'
			+'create table if not exists '+v+'\n'
			+'(\n'
				+ss+'\n'
			+');\n'
		
		rr+= 'insert into  '+v+'(';s.forEach(v=>rr+=v+',');rr=rr.slice(0,rr.length-1);rr+=')\n'
			+'values\n'
		for(let v of i)
		{
			vv=v.map(v=>'\''+v+'\'')
			rr+='('+''+vv+''+'),\n'
		}
		rr=rr.slice(0,rr.length-2)
			+';\n'


		rr+='\n------------------------------\n\n'
	}


	console.log(rr)
}


o={
    
    //schema: products
	company: [
		['co_name', 'govt_id', 'ceo_ssn', 'hq_loc'],
		['New York Tire', '111-22-3333', '999-00-0001', 'New York'],
		['New Jersey Tire', '222-33-4444', '999-00-0002', 'Trenton'],
		['Southern Axle', '333-44-5555', '999-00-0008', 'Atlanta'],
		['Atlanta Axle', '444-55-6666', '999-00-0003', 'Atlanta'],
		['Maryland Brake', '555-66-7777', '999-00-0004', 'Columbia'],
		['Georgia Brake', '666-77-8888', '999-00-0005', 'Atlanta'],
		['Florida Brake', '777-88-9999', '999-00-0006', 'Pensacola'],
		['Ohio Windshield', '888-99-0000', '999-00-0007', 'Toledo'],
	],
	division:[
		['co_id', 'div_name', 'subdiv_of', 'dir_ssn', 'div_hq'],
		['111-22-3333', 'research', 'innovation', '888-00-0001', 'Boston'],
		['666-77-8888', 'innovation', 'null', '888-00-0001 ', 'Valdosta'],
		['666-77-8888', 'research', 'innovation', '888-00-0001', 'Boston'],
		['666-77-8888', 'development', 'innovation', '888-00-0002', 'Nashville'],
		['333-44-5555', 'personnel', 'null', '888-00-0003', 'New York'],
		['333-44-5555', 'manufacturing', 'null', '888-00-0005', 'New York'],
		['333-44-5555', 'axle ', 'manufacturing', '888-00-0006', 'New York'],
		['333-44-5555', 'front axle ', 'axle', '888-00-0007', 'New York'],
		['333-44-5555', 'rearaxle', 'axle', '888-00-0008', 'New York'],
		['444-55-6666', 'communications', 'null', '888-00-0010', 'WestChester'],
		['444-55-6666', 'purchasing', 'null', '888-00-0011', 'Bensalem'],
	],
	works_for:[
		['ssn', 'co_id', 'div_name', 'salary', 'emp_id', 'sup_ssn'],
		['999-00-0001', '111-22-3333', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0001', '222-33-4444', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0001', '444-55-6666', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0001', '555-66-7777', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0001', '333-44-5555', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0002', '111-22-3333', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0003', '111-22-3333', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0003', '444-55-6666', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0004', '555-66-7777', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0005', '666-66-7777', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0006', '777-66-7777', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['999-00-0008', '888-66-7777', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['777-00-0001', '333-44-5555', 'front axle', 51000, 'EMP/FA-1', '888-00-0004'],
		['777-00-0002', '333-44-5555', 'front axle', 52000, 'EMP/FA-2', '888-00-0004'],
		['777-00-0003', '333-44-5555', 'front axle', 53000, 'EMP/FA-3', '888-00-0004'],
		['777-00-0004', '333-44-5555', 'front axle', 54000, 'EMP/FA-4', '888-00-0004'],
		['777-00-0005', '333-44-5555', 'null', 600000, 'EMP/1', 'null'],
		['777-00-0006', '333-44-5555', 'front axle', 56000, 'EMP/FA-6', '888-00-0004'],
	],
	person:[
		['ssn', 'name', 'address'],
		['999-00-0001', 'Joseph Jones', '76 Main Street, Atlanta, GA'],
		['999-00-0002', 'Daniel Smith', '42 Main Street, Atlanta, GA'],
		['999-00-0003', 'Donald Smith', '76 Main Street, Atlanta, GA'],
		['999-00-0004', 'Denis Smith', '90 Main Street, Atlanta, GA'],
		['999-00-0005', 'Joseph Jones', '76 Main Street, Atlanta, GA'],
		['999-00-0006', 'Joseph Jones', '76 Main Street, Atlanta, GA'],
		['999-00-0007', 'Joseph Jones', '76 Main Street, Atlanta, GA'],
		['999-00-0008', 'Joseph Jones', '76 Main Street, Atlanta, GA'],
		['777-00-0001', 'Jehosaphat Jones', '32 Main Street, Atlanta, GA'],
		['777-00-0002', 'Jennifer Jones', '29 Main Street, Atlanta, GA'],
		['777-00-0003', 'Janet Jones', '87 Main Street, Atlanta, GA'],
		['777-00-0004', 'Janice Jones', '63 Main Street, Atlanta, GA'],
		['777-00-0006', 'Jud Jones', '29 Main Street, Atlanta, GA'],
		['777-00-0005', 'Jerusha Jones', '29 Main Street, Atlanta, GA'],
	],
	skill:[
		['ssn', 'prod_id', 'manuf_co'],
		['999-00-0001', 'FA-S/1', '111-22-3333'],
		['999-00-0001', 'FA-S/2', '111-22-3333'],
		['999-00-0001', 'FA-L/1', '111-22-3333'],
		['999-00-0001', 'FA-L/2', '111-22-3333'],
		['999-00-0001', 'FA-L/3', '111-22-3333'],
		['999-00-0002', 'FA-S/1', '111-22-3333'],
		['999-00-0002', 'FA-S/2', '111-22-3333'],
		['999-00-0002', 'FA-L/1', '111-22-3333'],
		['999-00-0005', 'FA-S/1', '666-77-8888'],
		['999-00-0005', 'FA-S/1', '777-88-9999'],
		['999-00-0006', 'FA-S/1', '666-77-8888'],
		['999-00-0006', 'FA-S/1', '888-99-0000'],
		['999-00-0008', 'FA-L/2', '333-44-5555'],
		['777-00-0006', 'FA-L/1', '333-44-5555'],
		['777-00-0006', 'FA-L/2', '333-44-5555'],
		['777-00-0006', 'FA-L/3', '333-44-5555'],
	],
	site:[
		['co_id', 'div_name', 'loc'],
		['333-44-5555', 'front axle', 'Atlanta'],
		['333-44-5555', 'front axle', 'Valdosta'],
		['333-44-5555', 'front axle', 'Memphis'],
		['333-44-5555', 'manufacturing', 'Cleveland'],
		['333-44-5555', 'manufacturing', 'Nashville'],
		['333-44-5555', 'manufacturing', 'New Orleans'],
		['888-99-0000', 'purchasing', 'Toledo'],
		['888-99-0000', 'communications', 'Columbus'],
		['888-99-0000', 'communications', 'Dayton'],
	],

	product:[
		['prod_id', 'manuf_co', 'manuf_div', 'loc', 'prod_descr'],
		['FA-S/1', '111-22-3333', 'front axle', 'Valdosta', 'small light-weight front axle'],
		['FA-S/2', '111-22-3333', 'front axle', 'Valdosta', 'small heavy weight front axle'],
		['FA-L/1', '111-22-3333', 'front axle', 'Atlanta', 'large light-weight rust-proof front axle'],
		['FA-L/2', '111-22-3333', 'front axle', 'Atlanta', 'large light-weight plain front axle'],
		['FA-L/3', '111-22-3333', 'front axle', 'Atlanta', 'large medium-weight rust-proof front axle'],
	],

    //schema: projects
    department:[
        ['dname', 'dnumber', 'mgrssn', 'mgrstartdate'],
        ['R&D department', '5', '333', '1987'],
        ['Admin', '4', '555', '1990'],
        ['HQ', '1', '777', '2020'],
		['Market', '6', '333', '1987'],
		['Purchasing', '7', '333', '1987'],
		['Business', '8', '555', '1987'],
    ],
    dept_locations:[
        ['dnumber', 'dlocation'],
        ['1', 'Cleveland'],
		['1', 'Austin'],
        ['4', 'Stafford'],
		['4', 'Austin'],
        ['5', 'Chicago'],
		['6', 'Charlotte'],
		['7', 'Houston'],
		['8', 'Chicago'],
    ],
    project:[
        ['pname', 'pnumber', 'plocation', 'dnum'],
        ['x', '12', 'Bellaire', '1'],
        ['y', '22', 'Sugar', '1'],
        ['z', '32', 'Asdf', '5'],
		['a', '42', 'Asdf', '5'],
		['b', '52', 'Seattle', '6'],
    ],
    works_on:[
        ['essn', 'pno',  'hours'],
        ['123', '12', '23'],
        ['333', '12', '23'],
        ['333', '32', '23'],
        ['444', '42', '23']
    ],
    employee:[
        ['ssn', 'fname','minit','lname','superssn','salary','dno'],
        ['123','Liz','Aubrey','James', '333',20000,'1'],
		['777','Ada','Blaire','Johnson', '333',10000,'4'],
        ['333','Mary','Dakota','Booker', '444',10000,'5'],
        ['111','Jose','Eden','Howard', '555',12000,'6'],
        ['444','Liz','Gia','H', 'Wade',15000,'7'],
		['999','Ada','Hermione','Duncan', '555',20000,'7'],
        ['555','Ada','Aubrey','Robinson', '666',20000,'7']
    ],
	dependent:[
		['essn','dependent_name','sex','bdate','relationship'],
		['333','Kim','male','12/12/90','brother'],
		['333','Kelly','male','12/12/88','sister'],
		['333','James','male','12/12/60','father'],
		['555','Kim','male','12/12/90','brother'],
		['555','Molly','male','12/12/90','sister'],
	],
	//plane
	airport:[
		['airport_code', 'name', 'city', 'state'],
		['DFW', 'Dallas Fort Worth International Airport', 'Dallas', 'Texas'],
		['JFK', 'John F. Kennedy International Airport', 'Queens', 'Nebraska'],
		['ORD', 'Chicago OHare International Airport', 'Chicago', 'Nebraska'],
		['MDW', 'Chicago Midway International Airport', 'Chicago', 'Illinpos'],
		['IND', 'Indianapolis International Airport', 'Indianapolis', 'Nebraska'],
	],
	flight:[
		['number', 'airline', 'weekdays'],
		['1', 'Delta', 'M T W'],
		['2', 'Delta', 'W TR'],
		['3', 'United', 'M T W TR'],
		['4', 'American', 'M'],
		['5', 'American', 'M'],
	],
	flight_leg:[
		['flight_number', 'leg_number', 'departure_airport_code', 'scheduled_departure_time', 'arrival_airport_code', 'scheduled_arrival_time'],
		['1', '1', 'DFW', '0600', 'IND', 0700],
		['3', '2', 'DFW', '0800', 'ORD', 1100],
		['1', '3', 'IND', '0730', 'DFW', 1030],
		['2', '4', 'JFK', '1000', 'IND', 1200],
		['4', '5', 'MDW', '1300', 'JFK', 1500],
	],
	leg_instance:[
		['flight_number', 'leg_number', 'date', 'number_of_available_seats', 
		'airplane_id', 'departure_airport_code', 'departure_time', 'arrival_airport_code', 'arrival_time'],
		['1', '1', '12/01/03', 0, '100', 'DFW', 0600, 'IND', 0700],
		['1', '2', '12/01/03', 50, '101', 'IND', 0730, 'DFW', 1030],
		['2', '4', '12/01/03', 2, '102', 'JFK', 1000, 'IND', 1200],
		['2', '4', '12/01/03', 78, '103', 'JFK', 1000, 'IND', 1200],
		['4', '5', '12/01/03', 33, '104', 'MDW', 1300, 'JFK', 1500],
	],
	fares:[
		['flight_number', 'fare_code', 'amount', 'restrictions'],
		['1', '11', 100, '1 bag'],
		['3', '31', 300, '1 bag'],
		['2', '21', 300, '1 bag'],
		['4', '41', 20, '1 bag'],
		['5', '51', 175, '1 bag, upgrade eligible'],
	],
	airplane_type:[
		['type_name', 'max_seats', 'company'],
		['Boeing 737 MAX 7', 200, 'Boeing'],
		['Boeing 737 MAX 8', 197, 'Boeing'],
		['Boeing 737 MAX 9', 210, 'Boeing'],
		['Airbus A318', 130, 'Airbus'],
		['Airbus A220', 175, 'Airbus'],
	],
	can_land:[
		['airplane_type_name', 'airport_code'],
		['Airbus A220', 'DFW'],
		['Airbus A220', 'IND'],
		['Boeing 737 MAX 7', 'MDW'],
		['Boeing 737 MAX 8', 'JFK'],
		['Boeing 737 MAX 9', 'ORD'],
		['Airbus A220', 'MDW'],
		['Airbus A220', 'JFK'],
		['Airbus A220', 'ORD'],
	],
	airplane:[
		['airplane_id', 'total_number_of_seats', 'airplane_type' ],
		['100', 200, 'Boeing 737 MAX 7'],
		['101', 175, 'Airbus A220'],
		['102', 197, 'Boeing 737 MAX 8'],
		['103', 200, 'Boeing 737 MAX 7'],
		['104', 210, 'Boeing 737 MAX 9'],
	],
	seat_reservation:[
		['flight_number', 'leg_number', 'date', 'seat_number', 'customer_name', 'customer_phone' ],
		['1', '1', '12/01/03', 10, 'Smith', '555-555-5555'],
		['1', '1', '12/01/03', 12, 'Jones', '555-666-6666'],
		['1', '3', '12/01/03', 2, 'Smith', '555-555-5555'],
		['3', '2', '1/1', 8, 'Jones', '777-777-7777'],
		['4', '4', '1/2', 50, 'Doe', '555-666-6666'],
	],

	//
	storage:[
		['brand','type','model','count'],
		['Dell','laptop','XPS9520-7294WHT-PUS','3'],
		['Dell','laptop','XPS9320-7585SLV-PUS','3'],
		['Dell','laptop',' XPS9320-7523BLK-PUS','3'],
		['Lenovo','laptop','20UN000DUS','3'],
		['Lenovo','tablet','82QS001HUS','3'],
		['Lenovo','tablet','ZA940188US','3'],
		['HP','laptop','5-dy2702dx','3'],
		['HP','laptop','14a-ne0013dx','3'],
		['HP','printer','DeskJet 4133e','3'],
		['Acer','laptop','CP714-1WN-53M9','3'],
		['Acer','monitor','XZ320Q Pbiiphx','3'],
		['Acer','laptop','AN515-58-5046','3'],
		['MSI','laptop','Sword1512605','3'],
		['MSI','laptop','Sword1512295','3'],
		['MSI','laptop','Stealth7712231','3'],
	]
}

drop_create_insert(o)