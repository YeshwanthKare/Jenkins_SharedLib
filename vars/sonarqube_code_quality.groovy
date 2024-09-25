def call() {
  timeout(time: 20, unit: "MINUTES") {
      def result = waitForQualityGate abortPipeline: false
      echo "SonarQube Quality Gate result: ${result}"

      if (result.status == 'ERROR') {
          error("Quality gate check failed. Please fix issues.")
      } else if (result.status == 'WARN') {
          echo "Quality gate check passed with warnings."
      } else {
          echo "Quality gate check passed successfully."
      }
  }
}

