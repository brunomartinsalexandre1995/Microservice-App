import Vue from 'vue'
import Router from 'vue-router'
import Homepage from '@/components/Homepage'
import FourInLine from '@/components/FourInLine'
import Minesweeper from '@/components/Minesweeper'
import Draughts from '@/components/Draughts'
import axios from 'axios'
import VueAxios from 'vue-axios'



Vue.use(Router)



export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Homepage',
      component: Homepage
    },
    {
      path: '/four-in-line',
      name: 'FourInLine',
      component: FourInLine
    },
    {
      path: '/minesweeper',
      name: 'Minesweeper',
      component: Minesweeper
    },
    {
      path: '/draughts',
      name: 'Draughts',
      component: Draughts
    }
  ]
})
