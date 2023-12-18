# customcalender

        Step 1.Add it in your root build.gradle at the end of repositories

                   	dependencyResolutionManagement {
        		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        		repositories {
        			mavenCentral()
        			maven { url 'https://jitpack.io' }
        		}
        	}

        Step 2. Add the dependency


        	dependencies {
        	        implementation 'com.github.mdmasum-shuvo:customcalender:-SNAPSHOT' //latest version
        	}


        Step 3. Call 


        class MainActivity : ComponentActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
        
            // call viewmodel first
                val viewModel: CalenderViewModel = ViewModelProvider(this)[CalenderViewModel::class.java]
                //declare event if has
                val eventList = ArrayList<String>()
        
        
                setContent {
                    MycalenderTheme {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                        //declare to get seelcted date
                            val selectedDate = remember {
                                mutableStateOf("")
                            }
                            //add event
                            eventList.add("01/12/2023")
                            eventList.add("09/12/2023")
                            eventList.add("10/12/2023")
                            eventList.add("11/12/2023")
                            eventList.add("12/12/2023")
                            eventList.add("17/12/2023")
                            eventList.add("30/12/2023")
                            eventList.add("27/12/2023")
                            eventList.add("27/11/2023")
                            viewModel.createEvent(eventList)
                            viewModel.generateCalender()
        
                            LaunchedEffect(key1 = selectedDate.value, block = {
                                //do here
                                Log.e("selected date", "select date:" + selectedDate.value)
                            })
                            // call main calender screen 
                            MainCalenderScreen(viewModel, selectedDate = selectedDate)
                        }
                    }
                }
            }
        }
        
        
                
