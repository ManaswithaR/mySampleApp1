var movies=window.movies;
var books=window.books;
var shows=window.shows;
var products=[];
if(movies!==undefined && movies.length!==0){
	products=movies;
}else if(books!==undefined && books.length!==0){
	products=books;
	console.log(products);
}else if(shows!==undefined && shows.length!==0){
	products=shows;
}
console.log(products);
Vue.component('product',{
	  template:
	    `<div v-if='products.length!==0'><product-template v-for='(product,index) in products' :product='product'></product-template></div>`,
	    data() {
	    	return {
	    		products: products
	    	}
	    }	
	});
Vue.component('product-template', {
	 props:['product'],
	  template: 
	`<form :action='product.productType' method='POST'><div class='container'>
	<div class='product-box'>
	<div class='row col-lg-12 col-xs-12'>
	<div class='prod-image col-lg-3 col-xs-3'><input type='hidden' name='prodImage' :value='product.imgLink'/><img class='img-thumbnail' :src='product.imgLink'>
	</img></div><div class='col-lg-6 col-xs-6'>
	 <h3 class='prod-title'>{{product.productTitle}}</h3>
	  <p><span>Released:</span>{{product.released}}</p><p><span>Rating: </span>{{product.rating}}</p>
	  <p  v-if='product.director!==undefined'><span>Director: </span><span>{{product.director}}</span></p>
	  <p v-if='product.author!==undefined'><span>Author: </span><span>{{product.author}}</span></p>
	  <p v-if='product.trailer!==undefined'><span>Trailer: </span><a :href='product.trailer'>{{product.trailer}}</a></p>
	  <p><span>Price: </span><span><input type='hidden' name='quantity' :value='product.quantity'/><input type='hidden' name='price' :value='product.price'/>{{product.price}}</span></p>
	  </div>
	  <div class='col-xs-3 hidden-xs-down prod-button'><p><button class='btn btn-primary' type='submit'>add to cart</button></p>
	  </div>
	  <div class='col-lg-3 hidden-sm-up'><p>
	  <button  class='btn btn-primary' type='submit'>add to cart</button></p><input type='hidden' name='prodId' :value='product.productID'/><input type='hidden' name='title' :value='product.productTitle'/>
	  </div></div></div></div></form>`,
	});
if(document.getElementById('root')!==null){
	new Vue({
		el:'#root'
		
	});
}
	var carts=window.carts;
	if(carts !==null && carts.length != 0 )
	Vue.component('cart-summary', {
		 props:['cart'],
		  template: 
		` <div class='col-sm-12 d-flex flex-sm-row bg-cart-content justify-content-center'>
 <div class='p-2 col-sm-2'><img class='img-responsive img-thumbnail' :src='cart.itemImgUrl'></img></div>
 <div class='p-2 col-sm-2'><p>{{cart.itemName}}</p></div>
  <div class='p-2 col-sm-2'>
  <div class='form-group'>
  <select name='quantity'  class='form-control'>
  <option v-for='n in quan'>{{n}}</option>
  </select>
  </div>
  </div>
  <div class='p-2 col-sm-2'>{{cart.itemPrice}}</div>
  <div class='p-2 col-sm-2'><i class='fa fa-trash fa-lg' style='color:#004080' @click='removeItem(cart.cartId,"remove")'></i></div>
 
 </div>`,
 data:function(){
	return{
		quan:parseInt(this.cart.quantity)
	} 
 },

 methods:{
	 removeItem:function(id,actionType){
		 console.log("printing id"+id);
		 $('<input>').attr('type','hidden').attr('name','cartId').attr('value',id).appendTo('#paymentForm');
		 $('<input>').attr('type','hidden').attr('name','action').attr('value',actionType).appendTo('#paymentForm');
		 $('#paymentForm').submit();
	 } 
 }
		});
		new Vue({
			el:'#payment',
			data:{
				carts:carts,
				
			}
		
		});
