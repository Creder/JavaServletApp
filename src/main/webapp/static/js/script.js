function getJSON(url, callback) {
    fetch(url)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            callback(null, data);
        });
};

let url = "http://localhost:8080/SimpleWebApp_war/"
document.body.onload = getFanfics;

function getFanfics(){
    getJSON(url+"allfanfics",
        (err, data)=>{
            let divexp = document.getElementById("expl");
            divexp.innerHTML = '';
            for(let fanfic in data){
                let pp = document.createElement('div');
                pp.innerHTML = `<a href ="javascript::" onclick="getOneFanfic(${data[fanfic].fanficId})">${data[fanfic].title}</a>`
                divexp.append(pp);
            }
        });
}

function getOneFanfic(id){
	getJSON(url+"oneFanfic/"+id,
		(err, data)=> {
			let divexp = document.getElementById("expl");
			divexp.innerHTML = '';
			let pp = document.createElement('div');
			pp.innerHTML = `<a href ="javascript::" onclick="getFanfics()">Back</a>`+
							`<h1>${data.title}</h1>`+
							`<p>${data.content}`
			divexp.append(pp);
		})
}




	
