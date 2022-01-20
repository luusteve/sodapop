
import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
  name: 'sodapop',
  data () {
    return {
      name: '',
      weight: '',
      bottlingType: '',
      isFragile: '',
      unitsPerPack: '',
      volumePerUnit: '',
      count: '',
      selectedUuid: '',
      selectedName: '',
      selectedWeight: '',
      selectedBottlingType: '',
      selectedIsFragile: '',
      selectedUnitsPerPack: '',
      selectedVolumePerUnit: '',
      selectedCount: '',
      sodaPacks: [],
      newSodaPack: '',
      selectedSodaPack: '',
      errorSodaPack: '',
      response: []
    }
  },
  created: function () {
    // Initializing people from backend
    AXIOS.get(`/sodaPacks`)
      .then(response => {
        // JSON responses are automatically parsed.
        this.sodaPacks = response.data
      })
      .catch(e => {
        console.log(e)
        this.errorSodaPack = e
      })
  },
  methods: {
    createSodaPack: function (
      name,
      weight,
      count,
      isFragile,
      bottlingType,
      unitsPerPack,
      volumePerUnit
      ) {
      AXIOS.post('/sodaPacks',
        { 'name': name,
          'weight': weight,
          'count': count,
          'fragile': isFragile,
          'bottlingType': bottlingType,
          'unitsPerPack': unitsPerPack,
          'volumePerUnit': volumePerUnit
        })
      .then(response => {
        // JSON responses are automatically parsed.
        this.sodaPacks.push(response.data)
        this.newSodaPack = ''
        this.errorSodaPack = ''
      })
      .catch(e => {
        var errorMsg = e.response.data.message
        console.log(e.message)
        this.errorSodaPack = errorMsg
      })
    },
    updateSodaPack: function (
      uuid,
      name,
      weight,
      count,
      isFragile,
      bottlingType,
      unitsPerPack,
      volumePerUnit
      ) {
      AXIOS.put('/sodaPacks/' + uuid,
        { 'name': name,
          'weight': weight,
          'count': count,
          'fragile': isFragile,
          'bottlingType': bottlingType,
          'unitsPerPack': unitsPerPack,
          'volumePerUnit': volumePerUnit
        })
      .then(
        this.errorSodaPack = '',
        setTimeout(location.reload.bind(location), 60))
      .catch(e => {
        var errorMsg = e.response.data.message
        console.log(errorMsg)
        this.errorSodaPack = errorMsg
      })
    },
    selectSodaPack: function (
      uuid,
      name,
      weight,
      count,
      isFragile,
      bottlingType,
      unitsPerPack,
      volumePerUnit
    ) {
      this.selectedUuid = uuid,
      this.selectedName = name,
      this.selectedWeight = weight,
      this.selectedBottlingType = bottlingType,
      this.selectedCount = count,
      this.selectedIsFragile = isFragile,
      this.selectedUnitsPerPack = unitsPerPack,
      this.selectedVolumePerUnit = volumePerUnit
    },
    deleteSodaPack: function (
      uuid
    ) {
      AXIOS.delete('/sodaPacks/' + uuid)
      .then(
        this.errorSodaPack = '',
        setTimeout(location.reload.bind(location), 60))
      .catch(e => {
        var errorMsg = e.response.data.message
        console.log(errorMsg)
        this.errorSodaPack = errorMsg
      })
    },
    exportToCSV: function () {
      AXIOS.get('/sodaPacks/download')
      .then((response) => {
        var fileURL = window.URL.createObjectURL(new Blob([response.data]));
        var fileLink = document.createElement('a');
     
        fileLink.href = fileURL;
        fileLink.setAttribute('download', 'file.csv');
        document.body.appendChild(fileLink);
      
        fileLink.click();
   })
      .catch(e => {
        var errorMsg = e.response.data.message
        console.log(errorMsg)
        this.errorSodaPack = errorMsg
      })
    }
  }
}
