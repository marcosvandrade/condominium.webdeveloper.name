<template>
  <div class="flex-container">    
    <form>
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1">
      </div>
      <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>

</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
export default {
  name: 'App'
  // components: {
  //   HelloWorld
  }

</script>

<style>

/* body {
  background-color: #4b755505;
  font-family: Arial, Helvetica, sans-serif;
  width: 400px;
  margin: auto;
  padding: 150px 0;  
} */

.flex-container {
  display: flex;
  background-color: #4b755505;
}

/* 
.form-group {
  
} */


/* @import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css); */

</style>
