import Vue from 'vue'
import Router from 'vue-router'
import SodaPacks from '@/components/SodaPacks'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'SodaPacks',
      component: SodaPacks
    }
  ]
})
