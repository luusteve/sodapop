<template>
  <div id="sodapop">
    <h2>SodaPacks</h2>
    <div class="table-responsive">
        <table class="center" v-if="sodaPacks">
            <thead>
                <tr>
                    <th>SELECT UUID</th>
                    <th>name</th>
                    <th>weight (kg)</th>
                    <th>bottlingType</th>
                    <th>isFragile</th>
                    <th>unitsPerPack</th>
                    <th>volumePerUnit</th>
                    <th>Count</th>
                    <th>DELETE</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="sp in sodaPacks" :key="sp.uuid" class="sodaPack-data">
                    <td><button @click="selectSodaPack(sp.uuid, sp.name, sp.weight, sp.count, sp.fragile, sp.bottlingType, sp.unitsPerPack, sp.volumePerUnit)">{{sp.uuid}}</button></td>
                    <td>{{ sp.name }}</td>
                    <td>{{ sp.weight }}</td>
                    <td>{{ sp.bottlingType }}</td>
                    <td>{{ sp.fragile }}</td>
                    <td>{{ sp.unitsPerPack }}</td>
                    <td>{{ sp.volumePerUnit }}</td>
                    <td><b>{{ sp.count }}</b></td>
                    <td><button @click="deleteSodaPack(sp.uuid)">Delete SodaPack</button></td>
                    <!-- and so on -->
                </tr>
            </tbody>
        </table>
        <div>
          <button @click="exportToCSV()">Export To CSV</button>
        </div>
        <hr/>
          <h3>CREATE</h3>
        <table class="center">
          <thead>
                <tr>
                    <th>name</th>
                    <th>weight (kg)</th>
                    <th>bottlingType</th>
                    <th>isFragile</th>
                    <th>unitsPerPack</th>
                    <th>volumePerUnit</th>
                    <th>Count</th>
                </tr>
          </thead>

                <tbody>
                  <tr>
                    <td>
                      <input type="text" v-model="name" placeholder="Soda Name">
                    </td>
                    <td>
                      <input type="text" v-model="weight" placeholder="SodaPack weight">
                    </td>
                    <td>
                      <select v-model="bottlingType">
                        <option disabled value="">Please select one</option>
                        <option>CAN</option>
                        <option>PLASTIC</option>
                        <option>GLASS</option>
                      </select>
                    </td>
                    <td>
                      <input type="text" v-model="isFragile" placeholder="false">
                    </td>
                    <td>
                      <input type="text" v-model="unitsPerPack" placeholder="24">
                    </td>
                    <td>
                      <input type="text" v-model="volumePerUnit" placeholder="24">
                    </td>
                    <td>
                      <input type="text" v-model="count" placeholder="total packs">
                    </td>
                  </tr>
                </tbody>
        </table>
        <div>
          <button @click="createSodaPack(name,weight,count,isFragile,bottlingType,unitsPerPack,volumePerUnit)">Create SodaPack</button>
        </div>
        <hr/>
        <h3>UPDATE</h3>
        <table class="center">
          <thead>
                <tr>
                    <th>uuid</th>
                    <th>name</th>
                    <th>weight (kg)</th>
                    <th>bottlingType</th>
                    <th>isFragile</th>
                    <th>unitsPerPack</th>
                    <th>volumePerUnit</th>
                    <th>Count</th>
                </tr>
          </thead>

                <tbody>
                  <tr>
                    <td>
                      <input class="form-control" type="text" v-model="selectedUuid" :readonly="true">
                    </td>
                    <td>
                      <input type="text" v-model="selectedName" placeholder="Soda Name">
                    </td>
                    <td>
                      <input type="text" v-model="selectedWeight" placeholder="SodaPack weight">
                    </td>
                    <td>
                      <select v-model="selectedBottlingType">
                        <option disabled value="">Please select one</option>
                        <option>CAN</option>
                        <option>PLASTIC</option>
                        <option>GLASS</option>
                      </select>
                    </td>
                    <td>
                      <input type="text" v-model="selectedIsFragile" placeholder="false">
                    </td>
                    <td>
                      <input type="text" v-model="selectedUnitsPerPack" placeholder="24">
                    </td>
                    <td>
                      <input type="text" v-model="selectedVolumePerUnit" placeholder="24">
                    </td>
                    <td>
                      <input type="text" v-model="selectedCount" placeholder="total packs">
                    </td>
                  </tr>
                </tbody>
        </table>
        <div>
          <button @click="updateSodaPack(selectedUuid,selectedName,selectedWeight,selectedCount,selectedIsFragile,selectedBottlingType,selectedUnitsPerPack,selectedVolumePerUnit)">Update SodaPack</button>
        </div>
        <span v-if="errorSodaPack" style="color:red">Error: {{errorSodaPack}} </span>
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

.center {
  margin-left: auto;
  margin-right: auto;
}

table {
  table-layout: fixed ;
  width: 100% ;
}

</style>
