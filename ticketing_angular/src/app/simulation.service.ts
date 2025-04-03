import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class SimulationService {

  private apiUrl = 'http://localhost:8081/api/v1/simulation/start'; // Adjust base URL

  constructor() {}

  // Adjusted to not require configId anymore
  async startSimulation() {
    try {
      const response = await axios.post(this.apiUrl); // Just call the endpoint without configId
      return response.data;
    } catch (error) {
      console.error('Error starting simulation:', error);
      throw error;
    }
  }
}
