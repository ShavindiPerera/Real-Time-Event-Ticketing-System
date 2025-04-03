/*import { Routes } from '@angular/router';

export const routes: Routes = [];*/

import { Routes } from '@angular/router';
import { ConfigurationComponent } from './components/configuration/configuration.component';
import { SimulationComponent } from './components/simulation/simulation.component';


export const routes: Routes = [
  {
    path: '',
    component: ConfigurationComponent
  },
  {
    path:'',
    component: SimulationComponent
  }
];

