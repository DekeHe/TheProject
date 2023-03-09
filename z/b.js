const prompt = require("prompt-sync")({sigint: true})

 let capital=(s)=>
 {
    return s[0].toUpperCase()+s.substring(1)
 }

let initiate=(a)=>
{
    r=''
    for(let v of a)
    {
        r+='private '+v[1]+' '+v[0]+';'+'\n'
    }
    return r;
}

let constructor=(a)=>
{
    r='public '+className+"("
    for(let v of a)
    {
        r+=v[1]+" "+v[0]+","
    }
    r=r.slice(0,-1)+")"+"\n"
    r+="{"+"\n"
    
    for(let v of a)
    {
        r+="\t"+"this."+v[0]+"="+v[0]+";"+"\n"
    }
    r+="}"+"\n"
    return r
    
    

}


let getter_setter=(a)=>
{
    n=a.length
    r='' 
    for(i=0;i<n;i++)
    {
        r+= 'public '+a[i][1]+' get'+capital(a[i][0])+'(){return this.'+a[i][0]+';}'+'\n'
        r+='public void set'+capital(a[i][0])+'('+a[i][1]+' '+a[i][0]+'){this.'+a[i][0]+'='+a[i][0]+';}'+'\n'
        
    }

    return r
}

let to_string=a=>
{
    r=  '@Override'+'\n'
        +'public String toString()'+'\n'
        +'{'+'\n'
        +'\treturn '+'\n'

    mid=''
    for(let v of a)
    {
        mid+='+\"'+v[0]+':\"+this.'+v[0]+'+\"\\n\"'+'\n'
    }
    mid=''+(mid.slice(1,-1))+'; '+'\n'
    r+=mid

    r+='}'
    return r
}

className=prompt("className:")
n= prompt("n:")
a=[]
for(i=0;i<n;i++)
{
    the_name=prompt("name:")
    the_type=prompt("type:")
    a.push([the_name,the_type])
}

console.log('-'.repeat(40))

console.log('//')
console.log(initiate(a))

console.log('//')
console.log(constructor(a))

console.log('//')
console.log(getter_setter(a))

console.log('//')
console.log(to_string(a))

console.log('-'.repeat(40))


