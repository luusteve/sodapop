<template>
  <div id="sodapop">
    <h2>SODAPOP</h2>
  <div v-for="sp in sodaPacks" :key="sp.uuid" class="sodaPack-data">
      <div class="weather-stats">
        <div>
          <span>{{sp.uuid}}</span>
          <a :href="'/sodaPacks/' + sp.uuid">{{ sp.name }}</a>
        </div>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  name: 'sodapop',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<script src="./sodapop.js">
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
